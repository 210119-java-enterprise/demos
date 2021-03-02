package com.revature.config;

import com.revature.models.BaseballCoach;
import com.revature.models.Coach;
import com.revature.models.FootballCoach;
import com.revature.models.TrackCoach;
import com.revature.services.MotivationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.revature")
public class AppConfig {

    @Value("${coach.email}")
    private String coachEmail;

    @Bean
    @Scope("prototype")
    public Coach myCoach() {
        return new TrackCoach(myMotivationService());
    }

    @Bean
    public MotivationService myMotivationService() {
        return new MotivationService();
    }

    @Bean(initMethod="customInit", destroyMethod="customDestroy")
    public FootballCoach myFootballCoach() {
        FootballCoach coach = new FootballCoach();
        coach.setTeamName("The Cafebabes");
        coach.setEmail(coachEmail);
        coach.setMotivationService(myMotivationService());
        return coach;
    }

}
