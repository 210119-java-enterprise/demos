package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args){
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            if(conn == null){
                System.err.println("You didn't make a connection");
            }else{
                System.out.println("You made a connection");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
}
