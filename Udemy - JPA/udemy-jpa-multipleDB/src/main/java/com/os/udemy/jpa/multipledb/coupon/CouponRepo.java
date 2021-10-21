package com.os.udemy.jpa.multipledb.coupon;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long>{

}
