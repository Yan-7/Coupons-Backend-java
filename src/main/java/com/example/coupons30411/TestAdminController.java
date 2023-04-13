package com.example.coupons30411;

import com.example.coupons30411.controllers.AdminController;
import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

//@Component
public class TestAdminController implements CommandLineRunner {

    @Autowired
    private AdminController adminController;

    @Override
    public void run(String... args) throws Exception {

        Customer customer4 = new Customer(4, "Bob4", "Sponge", "bob4@", "1234", null);
        Customer customer5 = new Customer(11, "Bob5", "Sponge", "bob5@", "1234", null);

        Company comp1 = new Company(1, "MoshePhone", "Moshe@", "admin", null);
        Company comp2 = new Company(2, "MoshePhone2", "Moshe2@", "1234", null);
        Company comp3 = new Company(33, "test", "test@", "1234", null);

        adminController.login("admin@admin.com","admin");

//        adminController.getOneCompany(1);
//    adminController.addCompany(comp1);
//        adminController.addOneCustomer(customer4);
//         adminController.login("admin@admin.com","admin");

//        adminController.getOneCustomer(2);

//        System.out.println(adminController.getAllCompanies());
//        adminController.getAllCompanies();

//        adminController.getOneCompany(2);
//        adminController.addOneCustomer(customer5);
//        adminController.updateCustomer(customer5);
//        System.out.println(adminController.getAllCustomers());
//        adminController.deleteCustomer(9);
    }
}
