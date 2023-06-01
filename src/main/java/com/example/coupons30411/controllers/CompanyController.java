package com.example.coupons30411.controllers;


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Service
@Transactional
@RequestMapping("/company/api")
@RestController
public class CompanyController extends ClientController {

    @Autowired
    private CompanyService companyService;

//    @Override
//    @GetMapping("/login")
//    // TODO: 23/05/2023 change this
//    public String login(String email, String password) {
//        return "change me";
//    }

    //v
    @PostMapping("/add-coupon-to-company")
    public void addCoupon(@RequestBody Coupon coupon) {
        companyService.addCouponToCompany(coupon);
    }

    //v
    @DeleteMapping("/delete-coupon")
    public void deleteCoupon(int couponID) {
        companyService.deleteCoupon(couponID);
    }

    //v
    @GetMapping("/get-company-coupons")
    public List<Coupon> getCompanyCoupons() {
        return companyService.getCompanyCoupons();
    }

    //v
    @GetMapping("/get-coupons-by-category")
    public List<Coupon> getCompanyCouponsByCategory(@RequestParam Category category) {
        return companyService.getCompanyCouponsByCategory(category);
    }

    //vx - test works, swagger?
    @GetMapping("/get-coupons-by-max-price")
    public List<Coupon> getCompanyCouponsByMaxPrice(@RequestParam int maxPrice) {
       return companyService.getCompanyCouponsByMaxPrice(maxPrice);
    }

    //v
    @GetMapping("get-company-details")
    public Company getCompanyDetails() {
        return companyService.getCompanyDetails();
    }
}


