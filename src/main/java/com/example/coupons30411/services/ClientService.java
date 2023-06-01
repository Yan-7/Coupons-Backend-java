package com.example.coupons30411.services;


import com.example.coupons30411.repositories.CompanyRepository;
import com.example.coupons30411.repositories.CouponRepository;
import com.example.coupons30411.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {

    @Autowired
    public CouponRepository couponRepository;
    @Autowired
    public CompanyRepository companyRepository;
    @Autowired
    public CustomerRepository customerRepository;

    ClientService clientService;


    public abstract String login(String email, String password);
    
}
