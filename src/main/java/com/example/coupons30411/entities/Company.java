package com.example.coupons30411.entities;




import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = "coupons")
@Entity
public class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Coupon> coupons;

    public void attachCouponToCompany(Coupon coupon) {
        coupon.setCompany(this);
        this.coupons.add(coupon);
    }

    //works?
    public void deleteCouponsList() {
        coupons.clear();
        System.out.println("coupons list deleted");
    }
}
