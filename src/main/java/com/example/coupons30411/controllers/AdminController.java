package com.example.coupons30411.controllers;


import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// http://localhost:8080/
@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController extends ClientController {

    @Autowired
    AdminService adminService;

    @PostMapping("/login")
    @Override
    //v
    public String login(@RequestParam String email,@RequestParam String password) {
        return adminService.login(email,password);
    }

    //v
    @PostMapping("/add-company")
    public Company addCompany(@RequestBody Company company) throws CouponException {
        try {
            return this.adminService.addCompany(company);
        } catch (CouponException e) {
            throw new CouponException("cannot add company ERROR");
        }
    }

    // v
    @PostMapping("/add-customer")
    public void addOneCustomer(Customer customer) {
        try {
            adminService.addCustomer(customer);
        } catch (CouponException e) {
//            throw new RuntimeException(e);
            System.out.println("cannot add customer");
            return;
        }
        System.out.println(customer.getFirstName() + " customer saved");

    }
    //v
    @PostMapping("/update-company")
    public void updateCompany(@RequestBody Company company) {
        try {
            adminService.updateCompany(company);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }

    }
    //v
    @DeleteMapping("/delete-customer")
    public void deleteCustomer(int customerID) {
        try {
            adminService.deleteCustomer(customerID);
        } catch (CouponException e) {
            System.out.println("cannot delete customer");
            throw new RuntimeException(e);
        }
    }

    //v
    @GetMapping("/get-all-companies")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    //v
    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    //v
    @GetMapping("/get-one-company")
    public Company getOneCompany(int companyID) {
        Optional<Company> optionalCompany = null;
        try {
            optionalCompany = adminService.getOneCompany(companyID);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            System.out.println("getting company:");
            System.out.println(company);
            return company;
        }
        System.out.println("could not find company");
        return null;


    }


    //v
    @PostMapping("update-customer")
    public void updateCustomer(@RequestBody Customer customer) {
        try {
            adminService.updateCustomer(customer);
        } catch (CouponException e) {
//            throw new RuntimeException(e);
            System.out.println("cannot find customer");
        }
    }

    //v
    @GetMapping("/get-one-customer")
    public Optional<Customer> getOneCustomer(int customerID) {
        try {
            return adminService.getOneCustomer(customerID);
        } catch (CouponException e) {
            throw new RuntimeException("could not get customer by controller");
        }
    }

}
