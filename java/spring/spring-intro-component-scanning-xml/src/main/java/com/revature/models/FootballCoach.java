package com.revature.models;

import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @Lazy can be used to specify that a component should be lazily
// instantiated (even if it is a singleton)
@Lazy
@Component
public class FootballCoach implements Coach {

    // Spring can look up values from any configure property sources
    @Value("${coach.email}")
    private String email;

    // Literal string injection
    @Value("The Cafebabes")
    private String teamName;

    // Use the #{} syntax for calculated expressions
    @Value("#{34 + 12}")
    private int someCalculatedValue;

    // specify a default value in case some key is not found by Spring
    @Value("${coach.emailAndTeamName:defaultValue}")
    private String emailAndTeamName;

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

    public int getSomeCalculatedValue() {
        return someCalculatedValue;
    }

    public void setSomeCalculatedValue(int someCalculatedValue) {
        this.someCalculatedValue = someCalculatedValue;
    }

    public String getEmailAndTeamName() {
        return emailAndTeamName;
    }

    public void setEmailAndTeamName(String emailAndTeamName) {
        this.emailAndTeamName = emailAndTeamName;
    }

    @Autowired // @Inject (JEE annotation, which is functionally similar to Spring's @Autowired)
    public void setMotivationService(MotivationService motivationService) {
        System.out.println("FootballCoach.setMotivationService() invoked!");
        this.motivationService = motivationService;
    }

    @PostConstruct
    private void customInit() {
        System.out.println("FootballCoach.customInit() invoked!");
    }

    @PreDestroy
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
