package com.example.coupons30411.controllers;


import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// http://localhost:8080/
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController extends ClientController {

    // TODO: 12/04/2023 get attributes from admin service 
    private final static String emailA = "admin@admin.com";
    private final static String passwordA = "admin";

    @Autowired
    AdminService adminService;

    // TODO: 13/04/2023 through test- 0k , swagger- 200 but returns false 
    @GetMapping("/login")
    @Override
    public boolean login(String email, String password) {
        if (email == emailA && password == passwordA) {
            adminService.login(email, password);
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/test")
    public String testAdmin() {   // v
        System.out.println("admin test print");
        return "returning test string";
    }

    // TODO: 12/04/2023 "status": 400,
    //  "error": "Bad Request", 
    @PostMapping("/add-company")
    public Company addCompany(@RequestBody Company company) throws CouponException {
        try {
            return this.adminService.addCompany(company);
        } catch (CouponException e) {
            throw new CouponException("cannot add");
        }
    }


    // TODO: 12/04/2023 Error: response status is 400
    @PostMapping("/update")
    public void updateCompany(Company company) {
        try {
            adminService.updateCompany(company);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/delete") //v
    public void deleteCompany(int companyID) {
        try {
            adminService.deleteCompany(companyID);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }
    }

    //
    @GetMapping("/get-all")
    // TODO: 12/04/2023 Error: response status is 500
    // TODO: 12/04/2023 Cannot invoke "com.example.coupons30411.repositories.CompanyRepository.findAll()" because "this.adminService.companyRepository" is null
    public List<Company> getAllCompanies() {
        List<Company> allCompanies = adminService.companyRepository.findAll();
        System.out.println(allCompanies);
        return adminService.companyRepository.findAll();
    }

    // TODO: 13/04/2023 producing result but: "Failure while trying to resolve exception \"
    @GetMapping("get-one-company")
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


    @PostMapping("/add-customer") //v
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
//
//    }
//
//    public void updateCustomer(Customer customer) {
//        System.out.println(customer);
//        if (customerRepository.existsById(customer.getId())) {
//            customerRepository.save(customer);
//            System.out.println("customer updated");
//        } else System.out.println("cannot find customer");
//    }
//
////    public void deleteCustomer(int customerID)  {
////        Optional<Customer> customerOPT = customerRepository.findById(customerID);
////        if (customerOPT.isPresent()) {
////            customerRepository.deleteById(customerID);
////            System.out.println("customer " + customerID + " deleted");
////        }else System.out.println("cannot delete customer");
////    }
//
//
//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
////    public Customer getOneCustomer(int customerID) throws CouponsException {
////        Optional<Customer> optionalCustomer = customerRepository.findById(customerID);
////        if (optionalCustomer.isPresent()) {
////            Customer customer =optionalCustomer.get();
////            return customer;
////        } else System.out.println("cannot find customer");
////        return null;
////    }
//
//
}
