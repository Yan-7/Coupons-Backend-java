package com.example.coupons30411.tests;

import com.example.coupons30411.controllers.CompanyController;
import com.example.coupons30411.entities.Category;
import com.example.coupons30411.login.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
public class CompanyControllerTest implements CommandLineRunner {

    @Autowired
   CompanyController companyController;

    @Override
    public void run(String... args) throws Exception {

//        companyController.login("Moshe2@","1234", ClientType.Company);
//        System.out.println(companyController.getCompanyCoupons());
//        System.out.println(companyController.getCompanyCouponsByCategory(Category.ELECTRICITY));
//        System.out.println(companyController.getCompanyCouponsByMaxPrice(100));
        System.out.println(companyController.getCompanyDetails());










    }
}
