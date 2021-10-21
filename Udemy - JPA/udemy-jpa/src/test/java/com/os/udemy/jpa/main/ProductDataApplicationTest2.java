package com.os.udemy.jpa.main;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.product.Product;
import com.os.udemy.jpa.product.ProductRepository2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductDataApplicationTest2 {

    @Autowired
    ProductRepository2 repo;
    
    @Autowired
    EntityManager entityManager;
    
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
        List<Product> list = repo.findByPriceBetween(170d, 900d);
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }

    @Test
    public void testFindByDescLike() {
        List<Product> list = repo.findByDescLike("%un%");
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }

    @Test
    public void testFindByIdIn() {
        List<Product> list = repo.findByIdIn(java.util.Arrays.asList(1, 2, 3));
        list.forEach(product -> System.out.println(product.getName() + " --> " + product.getPrice()));
    }

    @Test
    public void testFindAllPaging() {
        Pageable p = PageRequest.of(1, 2);
        Page<Product> page = repo.findAll(p);
        page.forEach(pg -> System.out.println(pg.getName()));
    }

    @Test
    public void testFindAllSorting() {
        repo.findAll(Sort.by(Direction.DESC, "name", "price"))
                .forEach(product -> System.out.println(product.getName()));
        ;
    }

    @Test
    public void testFindAllSortingMany() {
        repo.findAll(Sort.by("price").descending().and(Sort.by("name").ascending()))
                .forEach(product -> System.out.println(product.getName()));
        ;
    }

    @Test
    public void testFindAllSortingPaging() {
        Pageable p = PageRequest.of(0, 2, Direction.DESC, "price");
        repo.findAll(p).forEach(product -> System.out.println(product.getName()));
        ;
    }
    
    @Test
    public void testFindByIdInSortingPaging() {
        Pageable p = PageRequest.of(0, 2, Direction.DESC, "price");
        repo.findByIdIn(java.util.Arrays.asList(3, 4), p).forEach(product -> System.out.println(product.getName()));
        ;
    }
    
    @Test
    @Transactional
    public void testChaching1() {
        repo.findById(1);
        repo.findById(1);
        repo.findById(1);
    }
    
    @Test
    @Transactional
    public void testChaching2() {
        Session session = entityManager.unwrap(Session.class);
        Product p = repo.findById(1).get();
        repo.findById(1);
        session.evict(p);
        repo.findById(1);
    }
}
