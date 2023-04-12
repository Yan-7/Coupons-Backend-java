package com.example.coupons30411;

import com.example.coupons30411.controllers.AdminController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestAdminController implements CommandLineRunner {

    private AdminController adminController;

    @Override
    public void run(String... args) throws Exception {

        adminController.login("Moshe2@","1234");

    }
}
