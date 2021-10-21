package com.os.udemy.jpa.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(Double from, Double to);
    List<Product> findByDescLike(String like);
    List<Product> findByIdIn(List<Integer> list);
    
    @Query(value = "select * from getallproducts()", nativeQuery = true)
    List<Product> findAllSP();
    
    @Query(value = "select * from getallproductsbyprice(:price)", nativeQuery = true)
    List<Product> getallproductsbyprice(@Param("price") int price);
    
    @Query(value = "select * from getallproductscountbyprice(:price)", nativeQuery = true)
    int getallproductscountbyprice(@Param("price") int price);
}
