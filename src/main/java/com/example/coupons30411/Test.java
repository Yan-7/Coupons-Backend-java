package com.example.coupons30411;

import com.example.coupons30411.controllers.AdminController;
import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.login.ClientType;
import com.example.coupons30411.services.AdminService;
import com.example.coupons30411.services.CompanyService;
import com.example.coupons30411.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

//@Component
public class Test implements CommandLineRunner {

    @Autowired
    AdminController adminController;

    @Autowired
    private AdminService adminService;

    @Autowired
    private CompanyService testCompanyService;
    @Autowired
    private CustomerService testCustomerService;


    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers;

        Customer customer1 = new Customer(1, "Bob", "Sponge", "bob@", "1234", null);
        Customer customer2 = new Customer(2, "Bob2", "Sponge2", "bob2@", "1234", null);
        Customer customer3 = new Customer(3, "Bob", "Sponge", "bob@", "1234", null);

        Company comp1 = new Company(1, "MoshePhone", "Moshe@", "admin", null);
        Company comp2 = new Company(2, "MoshePhone2", "Moshe2@", "1234", null);
        Company comp3 = new Company(3, "MoshePhone3", "Moshe3@", "1234", null);

        Coupon coupon1 = new Coupon(1, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2020, 1, 1), 100, 20, "image", null, comp2);
        Coupon coupon2 = new Coupon(2, Category.ELECTRICITY, "chip", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", null, comp2);
        Coupon coupon3 = new Coupon(3, Category.FOOD, "chips", "bla bla10", LocalDate.of(2000, 1, 1), LocalDate.of(2021, 1, 1), 100, 50, "image", null, comp2);
        Coupon coupon4 = new Coupon(4, Category.FOOD, "burger", "bla bla", LocalDate.of(2000, 1, 1), LocalDate.of(2030, 1, 1), 100, 99, "image", null, comp2);

        System.out.println("Admin service test started---------------------->");
//        AdminService admin = adminService.login("admin@admin.com", "admin",ClientType.Admin );
//        adminService.login("admin@admin.com", "admin");
        System.out.println();
        adminService.addOneCustomer(customer1);
        adminService.addOneCustomer(customer2);
        adminService.updateCustomer(customer1);
        adminService.addCompany(comp1);
        adminService.addCompany(comp2);
        adminService.addCompany(comp3);
        System.out.println("get company:");
        System.out.println(adminService.getOneCompany(comp1.getId()));
        System.out.println("getting customer:");
        System.out.println(adminService.getOneCustomer(1));
        adminService.deleteCustomer(2);                       //customer 2 deleted
        adminService.updateCompany(comp1);
//        adminService.deleteCompany(comp3.getId());   // TODO: 11/04/2023
        System.out.println("getting all customers:");
        System.out.println(adminService.getAllCustomers());
        System.out.println(adminService.getAllCompanies());
        System.out.println("<---------------------------------Admin service Test finished");
        System.out.println();

        //test for company service:
        System.out.println("Company service test started------------------------------>");
//        CompanyService companyService = (CompanyService) loginManager.login(comp2.getEmail(), comp2.getPassword(), ClientType.Company);
        testCompanyService.login(comp2.getEmail(), comp2.getPassword());
        testCompanyService.addCoupon(coupon1);
        testCompanyService.addCoupon(coupon2);
        testCompanyService.addCoupon(coupon3);
//        testCompanyService.updateCoupon(coupon1);
//        testCompanyService.deleteCoupon(2);
//        System.out.println(testCompanyService.getCompanyDetails());
//        System.out.println(testCompanyService.getCompanyCoupons());
//        System.out.println(testCompanyService.getCompanyCouponsByCategory(Category.FOOD));
//        testCompanyService.getCompanyCouponsByMaxPrice(70);
//        System.out.println("<--------------Company service test finished");
//        System.out.println();
//
//        //test for customer service
//        System.out.println("Customer Service test started--------------------->");
//        System.out.println();
//        System.out.println(testCustomerService.getCompanyDetails());
//        testCustomerService.addCoupon(coupon1);
//        testCustomerService.addCoupon(coupon3);
//        System.out.println("<---------------------Customer Service test finished");
//
//
//        adminController.testAdmin();


    }
}

