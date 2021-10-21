package com.os.udemy.jpa.main;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.product.Product;
import com.os.udemy.jpa.product.ProductRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductDataApplicationTest {
    
    @Autowired
    ProductRepository repo;
    
    @Test
    public void contextLoads() {
        
    }
    
    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(3);
        product.setName("Microwave");
        product.setDesc("Bosh");
        product.setPrice(150d);
        
        repo.save(product);
    }
    
    @Test
    public void testRead() {
        Product prod = repo.findById(1).get();
        assertNotNull(prod);
    }
    
    @Test
    public void testUpdate() {
        Product prod = repo.findById(1).get();
        prod.setPrice(1200d);
        repo.save(prod);
    }
    
    @Test
    public void testDelete() {
        if (repo.existsById(1)) {
            repo.deleteById(1);
        }
    }
    
    @Test
    public void testCount() {
        System.out.println("COUNT NUMBER: " + repo.count());
    }
    
    @Test
    public void testFindByName() {
        List<Product> list = repo.findByName("TV");
        list.forEach(product -> System.out.println(product.getName()));
    }
    
    @Test
    public void testFindByNameAndDesc() {
        List<Product> list = repo.findByNameAndDesc("TV", "Samsung");
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindByPriceGraterThan() {
        List<Product> list = repo.findByPriceGreaterThan(500d);
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindByDescContains() {
        List<Product> list = repo.findByDescContains("amsun");
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindByPriceBetween() {
        List<Product> list = repo.findByPriceBetween(170d,900d);
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindByDescLike() {
        List<Product> list = repo.findByDescLike("%un%");
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindByIdIn() {
        List<Product> list = repo.findByIdIn(java.util.Arrays.asList(1,2,3));
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }
    
    @Test
    public void testFindAllProductsSP() {
        repo.findAllSP().forEach(p -> System.out.println(p.getName()));
    }
    
    @Test
    public void testGetallproductsbyprice() {
        repo.getallproductsbyprice(150).forEach(p -> System.out.println(p.getName()));
    }
    
    @Test
    public void testGetallproductscountbyprice() {
        System.out.println("COUNT: " + repo.getallproductscountbyprice(150));
    }
}
