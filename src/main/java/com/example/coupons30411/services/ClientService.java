package com.example.coupons30411.services;


import com.example.coupons30411.repositories.CompanyRepository;
import com.example.coupons30411.repositories.CouponRepository;
import com.example.coupons30411.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {

    
    ClientService clientService;
    @Autowired
    public CompanyRepository companyRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public CouponRepository couponRepository;

    public boolean login(String email, String password) {
        return false;
    }
    
}
