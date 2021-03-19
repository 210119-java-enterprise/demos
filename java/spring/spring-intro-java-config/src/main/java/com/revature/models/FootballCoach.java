package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;

public class FootballCoach implements Coach {

    @Value("${coach.email}")
    private String email;

    @Value("The Cafebabes")
    private String teamName;

    private MotivationService motivationService;

    public FootballCoach() {
        System.out.println("FootballCoach no-args constructor invoked!");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public MotivationService getMotivationService() {
        return motivationService;
    }

    // Setter-based dependency injection (Spring recommends this for OPTIONAL dependencies)
    public void setMotivationService(MotivationService motivationService) {
        System.out.println("FootballCoach.setMotivationService() invoked!");
        this.motivationService = motivationService;
    }

    private void customInit() {
        System.out.println("FootballCoach.customInit() invoked!");
    }

    private void customDestroy() {
        System.out.println("FootballCoach.customDestroy() invoked!");
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Suicide runs to 40, 50, 60, 80, 100 yard lines";
    }

    @Override
    public String getMotivation() {
        return "The football coach says: " + motivationService.getMotivation();
    }
}
