package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("myCoach")
public class TrackCoach implements Coach {

    private MotivationService motivationService;

    // No @Autowired required here, because we are using constructor-based dependency injection
    public TrackCoach(MotivationService motivationService) {
        System.out.println("TrackCoach no-args constructor invoked!");
        this.motivationService = motivationService;
    }

    @Override
    public String getDailyWorkout() {
        return "Today's workout: Run a 30-minute 5k";
    }

    @Override
    public String getMotivation() {
        return "The track coach says: " + motivationService.getMotivation();
    }

    @Override
    public MotivationService getMotivationService() {
        return motivationService;
    }

}
