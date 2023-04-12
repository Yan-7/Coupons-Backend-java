package com.example.coupons30411.services;



import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.repositories.CompanyRepository;
import com.example.coupons30411.repositories.CouponRepository;
import com.example.coupons30411.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService extends ClientService {


    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public CouponRepository getCouponRepository() {
        return couponRepository;
    }

    private final static String email = "admin@admin.com";
    private final static String password = "admin";


    @Override
    public boolean login(String email, String password) {
        if (email == "admin@admin.com" && password == "admin") {
            System.out.println("login approved returns - true");
            return true;
        } else {
            System.out.println("cannot login, password or email incorrect");
            return false;
        }
    }

    public Company addCompany(Company company)  {
        String email = company.getEmail();
        String password = company.getPassword();
        if (companyRepository.findByEmail(company.getEmail()).isEmpty()) {
            companyRepository.save(company);
            System.out.println("company: " + company.getName() + " added to database");
            System.out.println();
            return company;
        } else {
            System.out.println("cannot add company " + company.getName() + " ,it's already exist in the system");
            System.out.println();
        }
        return null;
    }

    public void updateCompany(Company company) {
        if (companyRepository.existsById(company.getId())) {
            companyRepository.save(company);
            System.out.println("company " + company.getName() + " updated");
        } else {
            System.out.println("cannot update " + company.getName());

        }
    }

    public void deleteCompany(int companyID) {
        Optional<Company> companyOPT = companyRepository.findById(companyID);
        Company company = companyOPT.get();
        System.out.println("this is the company for deleting: " + company);

        if (companyRepository.existsById(companyID)) {
            companyRepository.deleteById(companyID);
            System.out.println(company.getName() + " was deleted from DB");
        } else {
            System.out.println("cannot delete company " + company.getName());
        }
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        System.out.println("getting all companies:");
        System.out.println(companies);

        return companies;
    }

    public Company getOneCompany(int companyID) throws CouponException {
        Optional<Company> optionalCompany = companyRepository.findById(companyID);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            System.out.println("getting company:");
            System.out.println(company);
            return company;
        }
        System.out.println("could not find company");
        return null;


    }

    public void addOneCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isEmpty()) {
//        if (customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
            System.out.println(customer.getFirstName() + " customer saved");
        } else {
            System.out.println("customer "+ customer.getFirstName() +" could not be added");
            System.out.println("customer email already exists");
        }

    }

    public void updateCustomer(Customer customer) {
        System.out.println(customer);
        if (customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
            System.out.println("customer updated");
        } else System.out.println("cannot find customer");
    }

    public void deleteCustomer(int customerID)  {
        Optional<Customer> customerOPT = customerRepository.findById(customerID);
        if (customerOPT.isPresent()) {
            customerRepository.deleteById(customerID);
            System.out.println("customer " + customerID + " deleted");
        }else System.out.println("cannot delete customer");
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // TODO: 27/12/2022
    public Optional<Customer> getOneCustomer(int customerID) {
        return this.customerRepository.findById(customerID);
    }




}
