package com.revature.config;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:app.properties")
@ComponentScan("com.revature") // if no package is specified, then Spring will scan the package that this class is in
public class AppConfig {

}
