
package com.revature.orm.models;

import com.revature.orm.annotations.Column;
import com.revature.orm.annotations.Entity;
import com.revature.orm.annotations.Id;

@Entity(tableName = "test")
public class Test {

    @Id(columnName = "id")
    private int id;

    @Column(columnName = "test_field_1")
    private String testField1;

    @Column(columnName = "test_field_2")
    private String testField2;
}
