package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {

    private MotivationService motivationService;

    public CodeCoach(@Qualifier("codeHypeService") MotivationService service) {
        System.out.println("CodeCoach constructor invoked!");
        this.motivationService = service;
    }

    @Override
    public String getDailyWorkout() {
        return "Complete 5 medium difficulty HackerRank challenge.";
    }

    @Override
    public String getMotivation() {
        return "The code coach says: " + motivationService.getMotivation();
    }

    @Override
    public MotivationService getMotivationService() {
        return motivationService;
    }

}
