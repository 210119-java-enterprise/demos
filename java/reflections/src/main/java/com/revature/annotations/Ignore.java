package com.revature.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(Eleme)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
}

/*
    Retention Policies:
        - SOURCE: The annotation is accessible during compilation
        - CLASS: The annotation is accessible during class loading
        - RUNTIME: The annotation is accessible at runtime.
 */