package com.revature.dao;

import com.revature.models.AppUser;
import com.revature.util.ConnectionFactory;
import com.revature.util.Set;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements CrudDao<AppUser> {

    public AppUser findUserByUsername(String username){

        AppUser user = null;

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "SELECT * FROM app_users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                user = new AppUser();
                user.setId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //If the user is anything but null, a persistence error will be thrown

        return user;
    }

    @Override
    public void save(AppUser newObj) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO app_users (username, password, first_name, last_name, role_id) " +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});

            pstmt.setString(1, newObj.getUserName());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4, newObj.getLastName());
            pstmt.setInt(5, newObj.getUserRole().ordinal()+1); //since sql is index 1 based, gotta add one to ordinal

            int rowsInserted = pstmt.executeUpdate();//used for DML statements except for select

            if(rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while(rs.next()){
                    newObj.setId(rs.getInt("user_id"));
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Set<AppUser> findAll() {
        System.err.println("not implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        System.err.println("not implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updObj) {
        System.err.println("not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.err.println("not implemented");
        return false;
    }
}
