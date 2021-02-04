package com.revature.repo;

import com.revature.account.Account;
import com.revature.account.AccountTypes;
import com.revature.models.AppUser;
import com.revature.util.ConnectionFactory;
import com.revature.util.LinkedList;

import java.sql.*;

import static com.revature.BankingApp.app;

public class AccountRepository implements CrudRepository<Account>{

    private final String base = "SELECT * " +
            "FROM balance ba " +
            "JOIN account_type ac " +
            "USING (account_typeId) ";

    @Override
    public void save(Account newObj) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO balance (account_balance, account_typeId, user_id) " +
                    "VALUES (?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"account_balanceid"});
            pstmt.setDouble(1, newObj.getBalance());
            pstmt.setInt(2, newObj.getAccountType().ordinal() + 1);
            pstmt.setInt(3,app().getCurrentSession().getSessionUser().getId());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                while (rs.next()) {
                    newObj.setAccountId(rs.getInt("account_balanceid"));
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public LinkedList<Account> findAll() {
        Connection conn = app().getCurrentSession().getConnection();
        LinkedList<Account> account = new LinkedList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(base);
            account = mapResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    @Override
    public Account findById(int id) {
        Account Id=null;
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = base + "WHERE account_balanceId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            Id = mapResultSet(rs).pop();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Id;
    }

    @Override
    public boolean update(Account updatedObj) {


        Connection conn = app().getCurrentSession().getConnection();

        try {
            String sql = "UPDATE balance SET account_balance=? WHERE account_balanceid=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, updatedObj.getBalance());
            pstmt.setInt(2, updatedObj.getAccountId());

            pstmt.executeUpdate();


        }catch(Exception e){
            System.out.println("failed to deposit or withdraw from account");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    private LinkedList<Account> mapResultSet(ResultSet rs) throws SQLException {

        LinkedList<Account> account = new LinkedList<>();

        while(rs.next()) {
            Account acc = new Account();
            acc.setAccountId(rs.getInt("account_balanceId"));
            acc.setAccountType(AccountTypes.valueOf(rs.getString("account_type")));
            acc.setBalance(rs.getDouble("account_balance"));
            account.insert(acc);
        }

        return account;

    }
}
