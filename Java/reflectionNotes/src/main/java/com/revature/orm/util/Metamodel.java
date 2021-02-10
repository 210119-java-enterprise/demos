package com.revature.orm.util;

public class Metamodel<T> {

    private Class<T> clazz;

    public Metamodel(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static <T> Metamodel<T> of(Class<T> clazz) {
        return new Metamodel<>(clazz);
    }

    public IdField getPrimaryKey() {

        Field[]
    }
}
