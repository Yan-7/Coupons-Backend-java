package com.example.coupons30411.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ClientController {

    public String login(String email,String password) {
        return "change me";
    }

//        @Override
//        @PostMapping("/login")
//        public boolean login(@RequestParam("username") String username,@RequestParam("password") String password) {
//            return customerService.login(username, password);
//        }


}
