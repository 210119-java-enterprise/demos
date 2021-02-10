package com.revature.orm;

import com.revature.orm.models.Test;
import com.revature.orm.models.User;
import com.revature.orm.util.ColumnField;
import com.revature.orm.util.Configuration;
import com.revature.orm.util.IdField;
import com.revature.orm.util.Metamodel;

import java.util.List;

public class OrmDriver {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(User.class)
           .addAnnotatedClass(Test.class);

        for (Metamodel<?> metamodel : cfg.getMetamodels()) {

            System.out.printf("Printing metamodel for class: %s\n", metamodel.getClassName());
            IdField idField = metamodel.getPrimaryKey();
            List<ColumnField> columnFields = metamodel.getColumns();

            System.out.printf("\tThe primary key of %s is: %s, which maps to the column with the name: %s\n", metamodel.getSimpleClassName(), idField.getName(), idField.getColumnName());

            for (ColumnField columnField : columnFields) {
                System.out.printf("\tThe %s class contains a column called: %s, which maps to the column with the name: %s\n", metamodel.getSimpleClassName(), columnField.getName(), columnField.getColumnName());
            }

            System.out.println();
        }



    }

}
