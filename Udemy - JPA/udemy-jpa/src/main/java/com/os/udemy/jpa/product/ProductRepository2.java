package com.os.udemy.jpa.product;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository2 extends PagingAndSortingRepository<Product, Integer>{
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(Double from, Double to);
    List<Product> findByDescLike(String like);
    List<Product> findByIdIn(List<Integer> list);
    List<Product> findByIdIn(List<Integer> list, Pageable pageable);
}
