package com.os.udemy.jpa.mongo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.mongo.entity.Product;
import com.os.udemy.jpa.mongo.repo.ProductRepo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MongoAppTests {
    
    @Autowired
    ProductRepo repo;
    
    @Test
    public void testSave() {
        Product p = new Product();
        p.setName("samsung");
        p.setPrice(12.34f);
        repo.save(p);
    }
    
    @Test
    public void testUpdate() {
        Product p = repo.findById("6113cf8c4039076b907bcd73").get();
        p.setPrice(50000f);
        repo.save(p);
    }
    
    @Test
    public void testFindAll() {
        repo.findAll().forEach(prod -> System.out.println(prod.getName() + ", " + prod.getPrice()));
    }
    
    @Test
    public void testDelete() {
        repo.deleteById("6113a1bb72fbb3c48598886a");
    }
}
