package com.example.coupons30411.tests;

import com.example.coupons30411.controllers.CustomerController;
import com.example.coupons30411.login.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class TestCustomerController implements CommandLineRunner {

    @Autowired
    CustomerController customerController;

    @Override
    public void run(String... args) throws Exception {

//        customerController.login("bob@","1234", ClientType.Customer);

    }
}
