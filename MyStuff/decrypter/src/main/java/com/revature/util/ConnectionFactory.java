package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory connFactory = new ConnectionFactory();//eager singleton

    private Properties props = new Properties();

    private ConnectionFactory() {
        try {
            props.load(new FileReader("src/main/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }

    public Connection getConnection() {

        Connection conn = null;

        try {

            Class.forName("org.postgresql.Driver");//force loads driver
            conn = DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("admin-usr"),
                    props.getProperty("admin-pw")
            );

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

}
