package com.revature.util;

import java.lang.reflect.Field;

public class IdField {
    
    private Field field;

    public IdField(Field field) {
        this.field = field;
    }

    public String getName() {
        return field.getName();
    }

    public Class<?> getType() {
        return field.getType();
    }
    
}
