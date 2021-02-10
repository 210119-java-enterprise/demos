package com.revature.orm;

import com.revature.orm.models.User;
import com.revature.orm.util.ColumnField;
import com.revature.orm.util.IdField;
import com.revature.orm.util.Metamodel;

import java.util.List;

public class OrmDriver {

    public static void main(String[] args) {

        Metamodel<User> userMetamodel = Metamodel.of(User.class);

        IdField idField = userMetamodel.getPrimaryKey();
        List<ColumnField> columnFields = userMetamodel.getColumns();

        System.out.printf("The primary key of User is: %s; which maps to the column with the name: %s\n", idField.getName(), idField.getColumnName());

        for (ColumnField columnField : columnFields) {
            System.out.printf("The User class contains a column called: %s; which maps to the column with the name: %s\n", columnField.getName(), columnField.getColumnName());
        }

    }

}
