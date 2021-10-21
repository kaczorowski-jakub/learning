package com.os.udemy.jpa.multipledb;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.multipledb.coupon.Coupon;
import com.os.udemy.jpa.multipledb.coupon.CouponRepo;
import com.os.udemy.jpa.multipledb.product.Product;
import com.os.udemy.jpa.multipledb.product.ProductRepo;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MultipleDbAppTest {
    
    @Autowired
    CouponRepo couponRepo;
    
    @Autowired
    ProductRepo productRepo;
    
    @Test
    public void testSaveCoupon() {
        Coupon coupon = new Coupon();
        coupon.setCode("SUPER-5");
        coupon.setDiscount(new BigDecimal(50));
        coupon.setExpDate("01/01/2022");
        System.out.println(couponRepo.save(coupon));
    }
    
    @Test
    public void testProductSave() {
        Product product = new Product();
        product.setCouponCode("SUPER");
        product.setDescription("Testing Product");
        product.setName("TV");
        product.setPrice(new BigDecimal(100));
        System.out.println(productRepo.save(product));
    }
    
}
