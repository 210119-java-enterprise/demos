package com.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Singleton class
public class ConnectionFactory {
    // <Singleton>
    // Eager Singleton -> creates object as soon as it loads
    private static ConnectionFactory connFactory = new ConnectionFactory();
    // Lazy Singleton will wait until getInstance() is called to create an instance

    // Can use this to access information in .properties file (username, password,
    // etc.)
    private Properties props = new Properties();

    {
        try {
            // Force loads driver so it's ready when we need to use it
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private ConnectionFactory() {
        super();
        try {
            props.load(new FileReader("day5demo/src/main/java/com/revature/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        return connFactory;
    }
    // </Singleton>

    public Connection getConnection() {

        Connection conn = null;

        try {
            // Don't put actual username and password in this file
            // Put in applications.properties file that isn't pushed to git
            conn = DriverManager.getConnection(
                props.getProperty("url"), 
                props.getProperty("admin-usr"), 
                props.getProperty("admin-password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;
    }

}
