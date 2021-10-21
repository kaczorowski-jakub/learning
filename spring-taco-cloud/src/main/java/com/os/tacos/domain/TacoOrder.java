package com.os.tacos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TacoOrder {
    
    @NotBlank(message="Delivery name is required")
    private String deliveryName;
    
    @NotBlank(message="Street is required")
    private String deliveryStreet;
    
    @NotBlank(message="City is required")
    private String deliveryCity;
    
    @NotBlank(message="State is required")
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    
    private List<Taco> tacos = new ArrayList<>();
    
    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
