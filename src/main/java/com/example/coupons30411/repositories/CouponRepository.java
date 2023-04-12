package com.example.coupons30411.repositories;


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByDescriptionAndCompany_Id(String description, int companyId);

    List<Coupon> findByIdAndCompany_id(int id, int id2);

    List<Coupon> findByCompany_id(int id);

    List<Coupon> findByCustomers_id(int id);

    List<Coupon> findByCompany_idAndCategory(int id, Category category);
    List<Coupon> findByCustomers_idAndCategory(int id, Category category);
    List<Coupon> findByCompany_idAndPriceLessThan(int id,double price);

    //program crashes because of this list
//    List<Coupon> findByExpirationAfter(Date date);
}
