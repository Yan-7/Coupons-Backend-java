package com.example.coupons30411.controllers;

import com.example.coupons30411.login.ClientType;
import com.example.coupons30411.login.LoginManager;
import com.example.coupons30411.services.ClientService;
import com.example.coupons30411.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@Service
@Transactional
@RestController
public class ClientController {

    @Autowired
    private LoginManager loginManager;

//    @Autowired
//    private CustomerService customerService;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");
        String clientType = loginRequest.get("clientType"); // TODO: 01/06/2023  
        // Check if email and password are present
        if (email != null && password != null) {
            return loginManager.login(email, password, ClientType.valueOf(clientType)).toString(); // TODO: 01/06/2023
        } else {
            // Handle invalid request or missing parameters
            throw new IllegalArgumentException("Invalid login request");
        }
    }

}
