package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {
    
    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            if (conn == null) {
                System.err.println("You didn't make a connection");
            } else {
                System.out.println("Works!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
