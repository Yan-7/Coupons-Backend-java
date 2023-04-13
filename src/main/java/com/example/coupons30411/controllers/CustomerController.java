package com.example.coupons30411.controllers;
//


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.repositories.CustomerRepository;
import com.example.coupons30411.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RestController
@RequestMapping("api/customer")
public class CustomerController extends ClientController {

    private Customer customer;

    @Autowired
    CustomerService customerService;

    //v
    @Override
    @GetMapping("/login")
    public boolean login(String email, String password) {
        return customerService.login(email, password);
    }

    //v
    @PostMapping("purchase-coupon")
    public void purchaseCoupon(int couponId) {
        customerService.purchaseCoupon(couponId);
    }

    //v
    @GetMapping("/get-customer coupons")
    public List<Coupon> getCustomerCoupons() {
        return customerService.getCustomerCoupons();
    }

    //v
    @GetMapping("/get-customers-coupons-by-category")
    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        return customerService.getCustomerCouponsByCategory(category);
    }

    //v
    @GetMapping("/get-customer-coupons-by-price")
    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }

    //v
    @GetMapping("/get-customer-details")
    public Optional<Customer> getCustomerDetails() {
        return customerService.getCustomerDetails();
    }


}
