package repository;

import db.MySqlConnection;
import models.Account;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccountRepository {
    private static Connection connection = MySqlConnection.createConnection();
    public void create(Account account){
        String sql = "INSERT INTO account VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getAccount_id());
            preparedStatement.setString(2, account.getFull_name());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setInt(6, account.getStatus());

            preparedStatement.executeUpdate();

            System.out.println("--correct insert on database");

        } catch(SQLException e) {
            System.out.println("--incorrect insert on database. " + e.getMessage());
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM account WHERE account_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            System.out.println("--correct delete ");

        } catch (SQLException e) {
            System.out.println("--incorrect delete . " + e.getMessage());
        }
    }

    public List<Account> getAll() {

        String  sql = "SELECT * FROM account";
        List<Account> acc = new ArrayList<Account>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Account a = new Account();

                a.setAccount_id(resultSet.getString("account_id"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setPassword(resultSet.getString("password"));
                a.setEmail(resultSet.getString("email"));
                a.setPhone(resultSet.getString("phone"));
                a.setStatus(resultSet.getInt("status"));

                acc.add(a);
            }

            System.out.println("--correct find");
            return acc;

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
            return null;
        }
    }

    public Account findById(String id){
        String sql = "select * from account where account_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account a = new Account();

                a.setAccount_id(resultSet.getString("account_id"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setPassword(resultSet.getString("password"));
                a.setEmail(resultSet.getString("email"));
                a.setPhone(resultSet.getString("phone"));
                a.setStatus(resultSet.getInt("status"));

                return a;
            }

            System.out.println("--correct find");

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
        }
        return null;
    }
    public boolean checkLogIn(String id, String pw){
        String sql = "select * from account where account_id = ? and password = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, pw);

            ResultSet rs = preparedStatement.executeQuery();

            System.out.println("--true");

            return rs.next();

        } catch(SQLException e) {
            System.out.println("--false " + e.getMessage());
        }
        return false;
    }
    public void update(Account account, String id) {
        String  sql = "UPDATE account SET full_name = ?, email = ?, phone = ? where account_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, account.getFull_name());
            preparedStatement.setString(2, account.getEmail());
            preparedStatement.setString(3, account.getPhone());
            preparedStatement.setString(4, id);

            preparedStatement.executeUpdate();

            System.out.println("--correct update on database");

        } catch(SQLException e) {
            System.out.println("--incorrect update on database. " + e.getMessage());
        }
    }
}
