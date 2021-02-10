package com.revature.orm.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Configuration {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private List<Metamodel<Class<?>>> metamodelList;

    @SuppressWarnings({ "unchecked" })
    public Configuration addAnnotatedClass(Class annotatedClass) {

        if (metamodelList == null) {
            metamodelList = new LinkedList<>();
        }

        metamodelList.add(Metamodel.of(annotatedClass));

        return this;
    }

    public List<Metamodel<Class<?>>> getMetamodels() {
        return (metamodelList == null) ? Collections.emptyList() : metamodelList;
    }

}
