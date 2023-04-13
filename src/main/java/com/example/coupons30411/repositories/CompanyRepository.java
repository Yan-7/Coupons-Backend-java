package com.example.coupons30411.repositories;


import com.example.coupons30411.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    Optional<Company> findByEmailAndPassword(String email, String password);

    List<Company> findByEmail(String email);

    List<Company> findByName(String name);

    Optional<Company> findById(int id);


}
