package com.example.coupons30411.login;


import com.example.coupons30411.services.AdminService;
import com.example.coupons30411.services.ClientService;
import com.example.coupons30411.services.CompanyService;
import com.example.coupons30411.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CompanyService companyService;

    public ClientService login(String email, String password, ClientType clientType) {
        // TODO: 16/02/2023 check password & email 
        switch (clientType) {
            case Admin:
                if (email == "admin@admin.com" && password == "admin") {
                    return adminService;
                }

        }
        return null;
    }
}




