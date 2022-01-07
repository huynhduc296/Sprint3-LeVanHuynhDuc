package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }
//    public static void main(String[] args) {
//        SpringApplication.run(com.example.demo.DemoApplication.class, args);
//        System.out.println(new BCryptPasswordEncoder().encode("2222222"));
//    }
}

