package com.revature.models;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

    // Gross. Tight coupling.
//    private MotivationService motivationService = new MotivationService();

    private MotivationService motivationService;

    // Constructor-based dependency injection (Spring recommends this for MANDATORY dependencies)
    public BaseballCoach(MotivationService motivationService) {
        System.out.println("BaseballCoach no-args constructor invoked!");
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Spend 30 minutes on batting practice.";
    }

    @Override
    public String getMotivation() {
        return "The baseball coach says: " + motivationService.getMotivation();
    }

    @Override
    public MotivationService getMotivationService() {
        return motivationService;
    }
}
