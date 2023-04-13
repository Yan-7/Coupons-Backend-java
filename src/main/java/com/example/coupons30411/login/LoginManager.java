//package com.example.coupons30411.login;
//
//
//import com.example.coupons30411.repositories.CompanyRepository;
//import com.example.coupons30411.repositories.CustomerRepository;
//import com.example.coupons30411.services.AdminService;
//import com.example.coupons30411.services.ClientService;
//import com.example.coupons30411.services.CompanyService;
//import com.example.coupons30411.services.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//// TODO: 13/04/2023 do i need the logging manager?
//@Service
//public class LoginManager { // TODO: 13/04/2023 how the loging method is connected?
//
//    @Autowired
//    private AdminService adminService;
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private CompanyService companyService;
//
//    @Autowired
//    private CompanyRepository companiesRep;
//
//    @Autowired
//    private CustomerRepository customerRep;
//
//
//    public ClientService login(String email, String password, ClientType clientType) {
//        switch (clientType) {
//            case Admin: {
//                if ("admin@admin.com".equals(email) && "admin".equals(password)) {
//                    return adminService;
//                }
//                break;
//            }
//            case Company: {
//                if (companiesRep.findByEmailAndPassword(email, password).isPresent()) {
//                    return companyService;
//                }
//                break;
//            }
//            case Customer: {
//                if (customerRep.findByEmailAndPassword(email, password).orElse(null) != null) {
//                    return customerService;
//                }
//                break;
//            }
//        }
//        System.out.println("Could not connect");
//        return null;
//    }
//
//}
//
//
//
//
