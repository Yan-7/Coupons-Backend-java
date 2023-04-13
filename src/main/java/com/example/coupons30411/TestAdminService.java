package com.example.coupons30411;

import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class TestAdminService implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {


        Company comp1 = new Company(1, "MoshePhone", "Moshe@", "admin", null);
        Company comp2 = new Company(2, "MoshePhone2", "Moshe2@", "1234", null);
        Company comp3 = new Company(33, "test", "test@", "1234", null);

        Customer customer1 = new Customer(1, "Bob", "Sponge", "bob@", "1234", null);
        Customer customer2 = new Customer(2, "Bob2", "Sponge2", "bob2@", "1234", null);
        Customer customer3 = new Customer(3, "Bob3", "Sponge", "bob3@", "1234", null);


//        adminService.addCustomer(customer3);
//        adminService.login("admin@admin.com","admin");
//    adminService.addCompany(comp3);
//          adminService.getOneCustomer(2);

//        System.out.println(adminService.getAllCompanies());
//        System.out.println(adminService.getOneCompany(2));
//        adminService.addCustomer(customer3);
//        adminService.updateCustomer(customer2);
//        adminService.deleteCustomer(customer2.getId());
//        adminService.deleteCompany(8);
//        System.out.println(adminService.getAllCustomers());
//        System.out.println(adminService.getOneCompany(2));
//        System.out.println(adminService.getOneCustomer(8));
//        adminService.deleteCustomer(11);
        }

}
