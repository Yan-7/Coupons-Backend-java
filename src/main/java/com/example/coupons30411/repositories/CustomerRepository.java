package com.example.coupons30411.repositories;

import com.example.coupons30411.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByEmailAndPassword(String email, String password);

    List<Customer> findByEmail(String email);

    List<Customer> findByPassword(String password);

    Optional<Customer> findById(int id); // TODO: 11/04/2023 works?


}
