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

    @Autowired
    AdminService adminService;

    // TODO: 13/04/2023 through test- 0k , swagger- 200 but returns false 
    @GetMapping("/login")
    @Override
    public boolean login(String email, String password) {
        return adminService.login(email,password);
    }

    @GetMapping("/test")
    public String testAdmin() {   // v
        System.out.println("admin test print");
        return "returning test string";
    }

    // TODO: 13/04/2023 terminal test ok, swagger: Error: response status is 400 
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

    //v
    @GetMapping("/get-all-companies")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    //v
    @GetMapping("get-all-customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    //v
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

    // terminal working, not swagger
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

    // TODO: 13/04/2023 test ok, swagger "Invalid character found in the request target-terminal"
    @PostMapping("update-customer")
    public void updateCustomer(Customer customer) {
        try {
            adminService.updateCustomer(customer);
        } catch (CouponException e) {
//            throw new RuntimeException(e);
            System.out.println("cannot find customer");
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
    @GetMapping("/get-one-customer")
    public Optional<Customer> getOneCustomer(int customerID) {
        try {
            return adminService.getOneCustomer(customerID);
        } catch (CouponException e) {
            throw new RuntimeException("could not get customer by controller");
        }
    }


}
