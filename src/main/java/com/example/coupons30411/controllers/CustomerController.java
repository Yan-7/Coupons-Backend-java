//package com.CouponsSysytemREST.controllers;
//
//import com.CouponsSysytemREST.entities.Coupon;
//import com.CouponsSysytemREST.entities.Customer;
//import com.CouponsSysytemREST.repositories.CompanyRepository;
//import com.CouponsSysytemREST.repositories.CouponRepository;
//import com.CouponsSysytemREST.repositories.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//@Transactional
//@RestController
//@RequestMapping("coupons/customerController")
//public class CustomerController extends ClientController {
//
//    @Autowired
//    private CouponRepository couponRepository;
//    @Autowired
//    private CompanyRepository companyRepository;
//    @Autowired
//    CustomerRepository customerRepository;
//    private Customer customer;
//
//    @Override
//    public boolean login(String email, String password)  {
//        Optional<Customer> customerOptional = customerRepository.findByEmailAndPassword(email, password);
//        if (customerOptional.isPresent()) {
//            customer = customerOptional.get();
//            System.out.println( customer.getFirstName()+ " "+customer.getLastName()+ " is logged in the system    ------------------------------>");
//            System.out.println();
//            return true;
//        }
//        System.out.println("login failed, customer was not found");
//        return false;
//    }
//
//    public void purchaseCoupon(int couponID) {
//        Optional<Coupon> optCoupon = this.couponRepository.findById(couponID);
//        if (optCoupon.isPresent()) {
//            Coupon coupon = optCoupon.get();
//            if (coupon.getEndDate().isAfter(LocalDate.now())) {
//                this.customer = this.customerRepository.save(customer);
//                customer.addCouponToCustomer(coupon);
//                coupon.setAmount(coupon.getAmount()-1);
//                System.out.println("coupon " + coupon.getId()+" purchased by " + customer.getFirstName());
//            }
//        } else System.out.println("coupon was not sold to customer");
//    }
//
//    public List<Coupon> getCustomerCouponsByCategory(Category category) {
//        List<Coupon> couponList = couponRepository.findByCustomers_idAndCategory(customer.getId(),category);
//        return couponList;
//////        List<Coupon> customerCoupons = customer.getCoupons();
////        for (Coupon c : customerCoupons) {
////            if (!c.getCategory().equals(category)) {
////                customerCoupons.remove(c);
////            }
////        System.out.println(category);
////        return customerCoupons;
//    }
//
//    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) {
//        List<Coupon> customerCoupons = this.customer.getCoupons();
//        if (customerCoupons.isEmpty()) {
//            System.out.println("customer coupons list is empty");
//            return null;
//        }
//        for (Coupon c : customerCoupons) {
//            if (c.getPrice() > maxPrice) {
//                customerCoupons.remove(c);
//            }
//        }
//        return customerCoupons;
//    }
//
//    public Customer getCustomerDetails() {
//        return this.customer;
//    }
//
//
//
//}
