package com.example.coupons30411.dailyJob;


import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

        //This class is a Spring component that is responsible for deleting expired coupons from the system.
//        It is scheduled to run on a daily basis using Springs scheduling capabilities. The class uses the CouponsRep
//        repository to retrieve a list of all coupons, checks their expiration date, and deletes them if they are expired.
//        The class also includes some basic print statements to log the start and completion of the deletion process.
//        Overall, this class effectively handles the deletion of expired coupons in a timely and automated manner
@Component
@DependsOn("coupons30411Application")  //force the Spring IoC container to initialize the bean
public class CouponExpiration {

    @Autowired
    private CouponRepository couponsRep;



    @Scheduled(fixedDelay = 24 * 60 * 60 * 1000, initialDelay = 10 * 1000)
    public void deleteExpiredCoupons() {

        System.out.println("------------------starting to delete expired coupons---------------------");
        List<Coupon> coupons = couponsRep.findAll();
        if (coupons.isEmpty()) {
            System.out.println("coupons list is empty, there is nothing to delete");
        } else {
            for (Coupon c : coupons) {
                if (c.getEndDate().isBefore(LocalDate.now())) {
                    couponsRep.deleteById(c.getId());
                    System.out.println("coupon " + c.getId() + " was deleted due to expiration on: " + c.getEndDate());
                }
            }
        }
    }
}