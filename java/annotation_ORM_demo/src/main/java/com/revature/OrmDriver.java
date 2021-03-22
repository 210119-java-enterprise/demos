package com.revature;

import java.util.List;

import com.revature.models.User;
import com.revature.util.ColumnField;
import com.revature.util.IdField;
import com.revature.util.Metamodel;

/**
 * Hello world!
 */
public final class OrmDriver {
    private OrmDriver() {
    }

    /**
     * Finds and prints id and columns of User object
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Metamodel<User> userMetamodel = Metamodel.of(User.class);

        IdField idField = userMetamodel.getPrimaryKey();
        List<ColumnField> columnFields = userMetamodel.getColumns();
        
        System.out.println("Primary key of User: " + idField.getName());

        for (ColumnField columnField : columnFields) {
            System.out.println("User class contains a column called: " + columnField.getName());
        }
    }
}
