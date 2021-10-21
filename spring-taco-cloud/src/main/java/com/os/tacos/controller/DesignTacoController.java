package com.os.tacos.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.os.tacos.domain.Ingredient;
import com.os.tacos.domain.Ingredient.Type;
import com.os.tacos.domain.IngredientByIdConverter;
import com.os.tacos.domain.Taco;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    
    private IngredientByIdConverter ibic;
    
    @Autowired
    public DesignTacoController(IngredientByIdConverter ibic) {
        this.ibic = ibic;
    }
    
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        for (Type type : Ingredient.Type.values()) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ibic.getIngredientMap().values(), type));
        }
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("taco", new Taco());
        return "design";
    }
    
    @PostMapping
    public String processTaco(Taco taco) {
        log.info("Processing taco " + taco);
        return "redirect:/orders/current";
    }
    
    private Iterable<Ingredient> filterByType(Collection<Ingredient> ingredients, Type type) {
        return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }

}
