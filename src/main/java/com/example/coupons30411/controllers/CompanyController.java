package com.example.coupons30411.controllers;


import com.example.coupons30411.entities.Coupon;
import com.example.coupons30411.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Service
@Transactional
@RequestMapping("api/company")
@RestController
public class CompanyController extends ClientController {

    @Autowired
    private CompanyService companyService;

    @Override
    @GetMapping("/login")
    //v returns true
    public boolean login(String email, String password) {
        return companyService.login(email,password);
    }

    // TODO: 13/04/2023 Error: response status is 400
    @PostMapping("/add-coupon-to-company")
    public void addCoupon(Coupon coupon) {
        companyService.addCouponToCompany(coupon);
    }
//
//    public void updateCoupon(Coupon coupon) {
//        if (!couponRepository.findByIdAndCompany_id(coupon.getId(), company.getId()).isEmpty()) {
//            couponRepository.save(coupon);
//            System.out.println("coupon " + coupon.getId() + " updated");
//        } else {
//            System.out.println("coupon was not found, cannot update");
//        }
//    }

    //v
    @DeleteMapping("delete-coupon")
    public void deleteCoupon(int couponID) {
        companyService.deleteCoupon(couponID);
    }

//    public List<Coupon> getCompanyCoupons() {
//        List<Coupon> companyCoupons = this.couponRepository.findByCompany_id(company.getId());
//
//        for (Coupon c : companyCoupons) {
//            System.out.println(c);
//        }
//        System.out.println("---------");
//        return companyCoupons;
//    }
//
//    public List<Coupon> getCompanyCouponsByCategory(Category category) {
//
//        List<Coupon> companyCouponsByCategory = couponRepository.findByCompany_idAndCategory(company.getId(), category);
//        System.out.println("category: " +category);
//        return companyCouponsByCategory;
//    }
//
//    public List<Coupon> getCompanyCouponsByMaxPrice(int maxPrice) {
//        List<Coupon> couponsListByPrice = couponRepository.findByCompany_idAndPriceLessThan(company.getId(), 150);
//        System.out.println("max price: " + maxPrice);
//        return couponsListByPrice;
//    }
//
//    // TODO: not working
//    public Company getCompanyDetails() {
//        Optional<Company> companyOpt = companyRepository.findById(this.company.getId());
//        if (companyOpt.isPresent()) {
//            this.company = companyOpt.get();
//            return company;
//        }
//        System.out.println("company not found");
//        return null;
//    }

    }
