package com.revature.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.revature.annotations.Column;
import com.revature.annotations.Id;

public class Metamodel<T> {
    
    private Class<T> clazz;

    public static <T> Metamodel<T> of(Class<T> clazz) {
        return new Metamodel<>(clazz);
    }

    public Metamodel(Class<T> clazz) {
        this.clazz = clazz;
    }

    public IdField getPrimaryKey() {
        Field [] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Id primaryKey = field.getAnnotation(Id.class);
            if (primaryKey != null) {
                return new IdField(field);
            }
        }
        throw new RuntimeException("Did not find a field annotated with @id in: " + clazz.getName());
    }

    public List<ColumnField> getColumns() {
        List<ColumnField> columnFields = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                columnFields.add(new ColumnField(field));
            }
        }

        if (columnFields.isEmpty()) {
            // Can use different exception or create own exception
            throw new RuntimeException("No columns found in: " + clazz.getName());
        }

        return columnFields;
    }
}
