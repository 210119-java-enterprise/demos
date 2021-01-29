package com.revature.util;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactoryTest {

    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            if (conn == null) {
                System.err.println("You didn't make a connection, noob.");
            } else {
                System.out.println("Ok so maybe you kinda know what you're doing.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
