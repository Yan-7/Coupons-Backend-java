package com.example.coupons30411.controllers;
//


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RestController
@RequestMapping("api/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController extends ClientController {

    private Customer customer;

    @Autowired
    CustomerService customerService;


    // TODO: 17/05/2023 not sure if working
    @PostMapping("/register")
    public ResponseEntity<String> addOneCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
        } catch (CouponException e) {
            System.out.println("cannot add customer");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add customer.");
        }
        System.out.println(customer.getFirstName() + " customer saved");
        return null;
    }




    @Override
    @GetMapping("/login")
    public boolean login(String email, String password) {
        return customerService.login(email, password);
    }


    @PostMapping("/purchase-coupon")
    public void purchaseCoupon(int couponId) {
        customerService.purchaseCoupon(couponId);
    }


    @GetMapping("/get-customer-coupons")
    public List<Coupon> getCustomerCoupons() {
        return customerService.getCustomerCoupons();
    }


    @GetMapping("/get-customers-coupons-by-category")
    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        return customerService.getCustomerCouponsByCategory(category);
    }


    @GetMapping("/get-customer-coupons-by-price")
    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }


    @GetMapping("/get-customer-details")
    public Optional<Customer> getCustomerDetails() {
        return customerService.getCustomerDetails();
    }


}
