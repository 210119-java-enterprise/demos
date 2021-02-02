package com.revature.repos;

import com.revature.models.AppUser;
import com.revature.models.UserRole;
import com.revature.util.ConnectionFactory;
import com.revature.util.LinkedList;
import com.revature.util.Set;
import sun.awt.image.ImageWatched;

import java.sql.*;
import java.util.Optional;

import static com.revature.Decrypter.app;

public class UserRepository implements CrudRepository<AppUser>{

    private final String base = "SELECT * " +
                                "FROM app_users au " +
                                "JOIN user_roles ur " +
                                "USING (role_id) ";

    // Returns appuser with corresponding username
    public AppUser findUserByUsername(String username) {

        AppUser user = null;

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = base + "WHERE username = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();
            user = mapResultSet(rs).pop();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // Returns AppUser of the corresponding username and password
    public Optional<AppUser> findUserByUsernameAndPassword(String username, String password) {

        Optional<AppUser> _user = Optional.empty();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = base + "WHERE username = ? AND password = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2,password);

            ResultSet rs = pstmt.executeQuery();
            _user = Optional.ofNullable(mapResultSet(rs).pop());
            // Optional.of will throw an exception if you pass a null object to it
            // Optional.ofNullable will allow storing a null value in it
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _user;
    }

    @Override
    public void save(AppUser newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO app_users (username, password, first_name, last_name, role_id) " +
                            "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"user_id"});
            pstmt.setString(1, newObj.getUsername());
            pstmt.setString(2,newObj.getPassword());
            pstmt.setString(3,newObj.getFirstName());
            pstmt.setString(4,newObj.getLastName());
            pstmt.setInt(5, newObj.getUserRole().ordinal()+1);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newObj.setId(rs.getInt("user_id"));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public LinkedList<AppUser> findAll() {

        Connection conn = app().getCurrentSession().getConnection();
        LinkedList<AppUser> users = new LinkedList<>();

        try {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(base);
            users = mapResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
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

    private LinkedList<AppUser> mapResultSet(ResultSet rs) throws SQLException {

        LinkedList<AppUser> users = new LinkedList<>();

        while (rs.next()) { // iterates through records/rows
            AppUser user = new AppUser();
            user.setId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setUserRole(UserRole.valueOf(rs.getString("role_name")));
            users.insert(user);
        }

        return users;
    }
}
