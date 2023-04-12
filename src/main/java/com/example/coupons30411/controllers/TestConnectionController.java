package com.example.coupons30411.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tester2")
//@CrossOrigin
public class TestConnectionController {


        @GetMapping("/greet")
        public String greet() {
            return "Hello";
        }

        @GetMapping("/add")
        public double add(@RequestParam double a, @RequestParam double b) {
            System.out.println(a+b);
            return a + b;
        }



}
