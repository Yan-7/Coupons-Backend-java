package com.example.coupons30411.controllers;


import com.example.coupons30411.controllers.ClientController;
import com.example.coupons30411.entities.Company;
import com.example.coupons30411.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
// http://localhost:8080/
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController extends ClientController {

    private final static String emailA = "admin@admin.com";
    private final static String passwordA = "admin";

    @Autowired
    AdminService adminService;


    @GetMapping("/login") // TODO: 11/04/2023 returning false from postman 
    @Override
    public boolean login(String email, String password) {
        if (email == emailA && password == passwordA) {
            System.out.println(email);
            System.out.println(password);
            System.out.println("login approved - return true");
            return true;
        } else {
            System.out.println("cannot login, password or email incorrect");
            return false;
        }
    }
    // v
    @GetMapping("/test")
    public String testAdmin() {
        System.out.println("admin test print");
        return "returning test string";
    }

    // TODO: 11/04/2023
    @PostMapping("/add-company")
    public Company addCompany(@RequestBody Company company) {
        return this.adminService.addCompany(company);
    }


//    public void updateCompany(Company company) {
//
//
//    }
//
//    public void deleteCompany(int companyID) {
//
//    }
//
    @GetMapping("/get-all")
    public List<Company> getAllCompanies() {
        List<Company> allCompanies = adminService.companyRepository.findAll();
        System.out.println(allCompanies);
        return adminService.companyRepository.findAll();
    }
//
//    public Company getOneCompany(int companyID) throws CouponsException {
//        Optional<Company> optionalCompany = companyRepository.findById(companyID);
//        if (optionalCompany.isPresent()) {
//            Company company = optionalCompany.get();
//            System.out.println("getting company:");
//            System.out.println(company);
//            return company;
//        }
//        System.out.println("could not find company");
//        return null;
//
//
//    }
//
//    public void addOneCustomer(Customer customer) {
//        if (customerRepository.findByEmail(customer.getEmail()).isEmpty()) {
////        if (customerRepository.existsById(customer.getId())) {
//            customerRepository.save(customer);
//            System.out.println(customer.getFirstName() + " customer saved");
//        } else {
//            System.out.println("customer "+ customer.getFirstName() +" could not be added");
//            System.out.println("customer email already exists");
//        }
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
