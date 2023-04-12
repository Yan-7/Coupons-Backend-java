package com.example.coupons30411;

import com.example.coupons30411.entities.Company;
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

        List<Company> companies = adminService.getAllCompanies();
        System.out.println(companies);

    }
}
