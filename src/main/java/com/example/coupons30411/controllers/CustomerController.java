package com.example.coupons30411.controllers;
//


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.security.JwtTokenUtil;
import com.example.coupons30411.services.CustomerService;
import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@Transactional
@RestController
@RequestMapping("/customer/api")
//@RequestMapping // the site is not yet divided into admin/company/customer
@CrossOrigin(origins = "http://localhost:3000") 
public class CustomerController extends ClientController {

    private Customer customer;

    @Autowired
    CustomerService customerService;


    @PostMapping("/register")
    public ResponseEntity<String> addOneCustomer(@RequestBody Customer customer) {
        try {
            customerService.addCustomer(customer);
        } catch (CouponException e) {
            System.out.println("cannot add customer");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot add customer.");
        }
        System.out.println(customer.getFirstName() + " customer saved");
        return null;
    }


    //loginsUrlCustomer= "http://localhost:8080/api/customer/login"; in client.config
//    @PostMapping("/login")
//    public String login(@RequestBody Map<String, String> loginRequest) {
//        String email = loginRequest.get("email");
//        String password = loginRequest.get("password");
//        // Check if email and password are present
//        if (email != null && password != null) {
//            return customerService.login(email, password);
//        } else {
//            // Handle invalid request or missing parameters
//            throw new IllegalArgumentException("Invalid login request");
//        }
//    }

    @PostMapping("customer/purchase-coupon")
    public void purchaseCoupon(int couponId) {
        customerService.purchaseCoupon(couponId);
    }

    @GetMapping("customer/get-customer-coupons")
    public List<Coupon> getCustomerCoupons() {
        return customerService.getCustomerCoupons();
    }


    @GetMapping("/get-customers-coupons-by-category")
    public List<Coupon> getCustomerCouponsByCategory(@RequestParam("category") String category) {
        return customerService.getCustomerCouponsByCategory(Category.valueOf(category));
    }


    @GetMapping("/customer/get-customer-coupons-by-price")
    public List<Coupon> getCustomerCouponsByMaxPrice(@RequestParam("maxPrice") Double maxPrice) {
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }


    @GetMapping("/customer/get-customer-details")
    public Optional<Customer> getCustomerDetails() {
        return customerService.getCustomerDetails();
    }


}
