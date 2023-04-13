package com.example.coupons30411.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private Category category;

    private String title;
    private String description;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;
    private int amount;
    private double price;
    private String image;

    @JsonIgnore
    @ManyToMany(mappedBy = "coupons", cascade = CascadeType.DETACH)
    @ToString.Exclude
    private List<Customer> customers;

    @JsonIgnore //?
    @ManyToOne
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;
}
