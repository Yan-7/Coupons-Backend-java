package com.example.coupons30411.services;


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.entities.Customer;
import com.example.coupons30411.exceptions.CouponException;
import com.example.coupons30411.security.JwtTokenUtil;
import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




// TODO: 13/04/2023 change class with the updated one
@Service
@Transactional
public class CustomerService extends ClientService {

    private int customerId;


    @Autowired
    private EntityManager entityManager;

    @Override
    public String login(String userName, String password) {
        System.out.println( userName +" " + password);
        Optional<Customer> customerOpt = customerRepository.findByUserNameAndPassword(userName, password);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            this.customerId = customer.getId();
            String token = JwtTokenUtil.generateToken(String.valueOf(customerId));
            System.out.println("Login successful, customer " + customer.getFirstName() + " is logged in, token returned");
            return token;
        }
        System.out.println("login failed (customerService message)");
        System.out.println("customer id;" + customerId);
        return null;
    }
    public void addCustomer(Customer customer) throws CouponException { //v
        customer.setId(0); //?
        if (customerRepository.existsById(customer.getId())) {
//            throw new CouponException("customer " + customer.getFirstName() + " already exist");
            System.out.println("customer " +customer.getFirstName() +" already exist");
            return;
        }
        customerRepository.save(customer);
        System.out.println("customer" + customer.getFirstName() + " saved");
    }

    //v
    public void purchaseCoupon(int couponId) {  //v
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer1 = customerOpt.get();
            System.out.println();
            System.out.println("customer for adding coupon: " + customer1);
            Optional<Coupon> optionalCoupon = couponRepository.findById(couponId);
            System.out.println("the coupon: " + optionalCoupon);
            if (optionalCoupon.isPresent()) {
                Coupon coupon1 = optionalCoupon.get();
                customer1.attachCouponToCustomer(coupon1);
                coupon1.setAmount(coupon1.getAmount() - 1);
                return;
            }
        }
        System.out.println("could not add coupon to customer");
    }

    public List<Coupon> getCustomerCoupons() { //v
        System.out.println("customer " + customerId + " coupons:");
        return couponRepository.findByCustomers_id(customerId);
    }


    @Transactional
    public List<Coupon> getCustomerCouponsByCategory(Category category) {  //v
        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            System.out.println("customer coupons by category: " + category);
            List<Coupon> customerCoupons = customer.getCoupons();
            System.out.println(customerCoupons);
            // load the coupons eagerly before the session is closed
            System.out.println("size: " + customerCoupons.size());

            List<Coupon> result = new ArrayList<>();
            for (Coupon coupon : customerCoupons) {
                if (coupon.getCategory().equals(category)) {
                    result.add(coupon);
                }
            }
            System.out.println("coupons by category: " + category);
            System.out.println(result);
            return result;
        }
        System.out.println("could not find coupon");
        return null;
    }
    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) { //v
        List<Coupon> customerCoupons = couponRepository.findByCustomers_id(customerId);

        if (!customerCoupons.isEmpty()) {
            List<Coupon> customerCoupons2 = new ArrayList<>();
            for (Coupon c : customerCoupons) {
                if (c.getPrice() <= maxPrice) {
                    customerCoupons2.add(c);
                }
            }
            System.out.println("customer coupons by price: " + maxPrice);
            System.out.println(customerCoupons2);
            return customerCoupons2;
        }
        System.out.println("could not find coupons by max price "+ maxPrice);
        return null;
    }


    public Optional<Customer> getCustomerDetails() { //v
        System.out.println("customer details:");
        return customerRepository.findById(customerId);
    }

}
