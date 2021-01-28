package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;

//eager singleton - makes sure only one object is created
public class ConnectionFactory {

    // so static means it is created when it is loaded into memory
    private static ConnectionFactory connFactory = new ConnectionFactory();

    //singleton step 1
    private ConnectionFactory() {
        super();
    }

    //singleton step 2
    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
