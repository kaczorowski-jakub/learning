package com.os.udemy.jpa.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.os.udemy.jpa.mongo.entity.Product;

public interface ProductRepo extends MongoRepository<Product, String>{

}
