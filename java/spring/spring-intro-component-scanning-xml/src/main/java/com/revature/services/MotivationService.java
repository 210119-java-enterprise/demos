package com.revature.services;

import org.springframework.stereotype.Service;

@Service
public class MotivationService {

    public MotivationService() {
        System.out.println("MotivationService no-args constructor invoked!");
    }

    public String getMotivation() {
        return "Don't quit. Suffer now and live the rest of your life like a champion.";
    }
}
