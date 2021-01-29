package com.revature.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;
import com.revature.util.Set;
import com.revature.models.AppUser;

public class UserRepository implements CrudRepository<AppUser> {

    @Override
    public void save(AppUser newObj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO app_users (username, password, first_name, last_name, role_id) VALUES" +
                "(?, ?, ?, ?, ?)";
            // When insert user, give me access to user id
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2, newObj.getPassword());
            pstmt.setString(3, newObj.getfName());
            pstmt.setString(4, newObj.getlName());
            // Gets the int associated with the user role in UserRole and adds 1 so it matches
            //  with number in database
            pstmt.setInt(5, newObj.getUserRole().ordinal() + 1);
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newObj.setId(rs.getInt("user_id"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set findAll() {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updatedObj) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        // TODO Auto-generated method stub
        System.err.println("Not implemented");
        return false;
    }

    public AppUser findUserByUsername(String username) {
        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            // ? is where the username will go (in PreparedStatement)
            String sql = "SELECT * FROM app_users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 1-indexed
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            // Map result set onto an AppUser
            while (rs.next()) {
                user = new AppUser();
                user.setId(rs.getInt("user_id"));
                user.setfName(rs.getString("first_name"));
                user.setlName(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }

    
}
