package com.example.coupons30411;

import com.example.coupons30411.controllers.AdminController;
import com.example.coupons30411.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestAdminController implements CommandLineRunner {

    @Autowired
    private AdminController adminController;

    @Override
    public void run(String... args) throws Exception {

        Customer customer4 = new Customer(4, "Bob4", "Sponge", "bob4@", "1234", null);
        Customer customer5 = new Customer(5, "Bob5", "Sponge", "bob5@", "1234", null);

         adminController.login("admin@admin.com","admin");

//        adminController.getAllCompanies();


//        adminController.getOneCompany(2);
        adminController.addOneCustomer(customer5);
    }
}
