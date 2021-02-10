package com.revature.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
}

/*
    Retention Policies:
        - SOURCE: the annotation is accessible during compilation
        - CLASS: the annotation is accessible during class loading
        - RUNTIME: the annotation is accessible at runtime
 */
