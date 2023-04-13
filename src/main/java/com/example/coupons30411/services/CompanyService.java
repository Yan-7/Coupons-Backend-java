package com.example.coupons30411.services;


import com.example.coupons30411.entities.Category;
import com.example.coupons30411.entities.Company;
import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.repositories.CompanyRepository;
import com.example.coupons30411.repositories.CouponRepository;
import com.example.coupons30411.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService extends ClientService {

    private int companyId;
    @Autowired
    private EntityManager entityManager; //EntityManager represents a connection to the database and provides methods for managing entities.


    @Override
    public boolean login(String email, String password) { //v
        Optional<Company> companyOpt = companyRepository.findByEmailAndPassword(email, password);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            this.companyId = company.getId();
            System.out.println("company " + company.getName() + " Login successful");
            return true;
        }
        System.out.println("could not login");
        return false;
    }

    public void addCouponToCompany(Coupon coupon) { //v
        Optional<Company> optionalCompany = this.companyRepository.findById(companyId);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            Coupon mergedCoupon = entityManager.merge(coupon); // Reattaches the Coupon object to the current session
            company.attachCouponToCompany(mergedCoupon);
            System.out.println("Coupon " + mergedCoupon.getId() + " was added to company " + company.getId());
        } else {
            System.out.println("Could not add coupon to company");
        }
    }

    public void updateCoupon(Coupon coupon) { //v
        if (couponRepository.existsById(coupon.getId())) {
            this.couponRepository.save(coupon);
            System.out.println("coupon " + coupon.getId() + " updated to repository");
        } else {
            System.out.println("coupon not found, could not update coupon");
        }
    }

    public void deleteCoupon(int couponId) { //v
        if (couponRepository.existsById(couponId)) {
            couponRepository.deleteById(couponId);
            System.out.println("coupon " + couponId + " deleted");
        } else {
            System.out.println("could not delete coupon");
        }
    }

    public List<Coupon> getCompanyCoupons() { //v
        List<Coupon> companyCoupons = couponRepository.findByCompany_id(companyId);
        if (!companyCoupons.isEmpty()) {
            System.out.println("list of all company coupons:");
            return companyCoupons;
        } else {
            System.out.println("could not find coupons");
            return null;
        }
    }

    public List<Coupon> getCompanyCouponsByCategory(Category category) { //v
        List<Coupon> companyCoupons = getCompanyCoupons();
        List<Coupon> companyCoupons2 = new ArrayList<>();
        if (!companyCoupons.isEmpty()) {
            System.out.println("company coupons by category: " + category);
            return companyCoupons;
        }

        System.out.println("could not find coupons by category " + category);
        return null;

    }

    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) { //v
        List<Coupon> companyCoupons = getCompanyCoupons();
        if (!companyCoupons.isEmpty()) {
            List<Coupon> companyCoupons2 = new ArrayList<>();
            for (Coupon c : companyCoupons) {
                if (c.getPrice() <= maxPrice) {
                    companyCoupons2.add(c);
                }
            }

            if (!companyCoupons2.isEmpty()) {
                System.out.println("list of coupons by max price " + maxPrice);
                System.out.println(companyCoupons2);
                return companyCoupons2;
            }
        }
        System.out.println("could not find coupons by company id: " + companyId + "and max price: " + maxPrice);
        return null;
    }

    public Company getCompanyDetails() { //v
        Optional<Company> optional = companyRepository.findById(companyId);
        if (optional.isPresent()) {
            Company company = optional.get();
            System.out.println("company details: ");
            return company;
        } else {
            System.out.println("could not find company");
            return null;
        }
    }
}
