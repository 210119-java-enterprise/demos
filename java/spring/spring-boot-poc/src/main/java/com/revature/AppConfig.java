package com.revature;

import com.revature.models.AppUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // implies @Configuration, @EnableAutoConfiguration, and @ComponentScan
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

}
