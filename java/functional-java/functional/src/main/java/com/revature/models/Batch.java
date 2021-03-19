package com.revature.models;

public class Batch {
    private String name;
    private TechStack stack;

    public enum TechStack {
        JAVA_ANGULAR, JAVA_REACT, C_SHARP_ANGULAR, C_SHARP_REACT, PYTHON
    }

    public Batch(String name, TechStack stack) {
        this.name = name;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechStack getStack() {
        return stack;
    }

    public void setStack(TechStack stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return "Batch [name=" + name + ", stack=" + stack + "]";
    }
}
