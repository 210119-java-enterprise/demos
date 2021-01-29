package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.util.ConnectionFactory;
import com.revature.util.Set;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements CrudRepository<AppUser>{

    public AppUser findUserByUsername(String username) {
        AppUser user = null;

            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

                String sql = "SELECT * FROM app_users WHERE username = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, username);

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()){
                    user.setId(rs.getInt("user_id"));
                    user.setFirstName(rs.getString("first_name"));
                    user.setLastName(rs.getString("last_name"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));

                }

            } catch (SQLException e){
            e.printStackTrace();
        }

            return user;
    }

    @Override
    public void save(AppUser newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO app_users (username, password, first_name, last_name, role_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2,newObj.getPassword());
            pstmt.setString(3, newObj.getFirstName());
            pstmt.setString(4,newObj.getLastName());
            pstmt.setInt(5,newObj.getUserRole().ordinal() + 1);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()){
                    newObj.setId(rs.getInt("user_id"));
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<AppUser> findAll() {
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public AppUser findById(int id) {
        System.err.println("Not implemented");
        return null;
    }

    @Override
    public boolean update(AppUser updatedObj) {
        System.err.println("Not implemented");
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        System.err.println("Not implemented");
        return false;
    }
}
