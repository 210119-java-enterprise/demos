package com.revature.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("codeHypeService")
public class CodeMotivationService implements MotivationService {

    @Override
    public String getMotivation() {
        return "Don't quit. Suffer now and code the rest of your life like a boss.";
    }

}
