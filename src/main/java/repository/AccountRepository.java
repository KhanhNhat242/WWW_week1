package repository;

import db.MySqlConnection;
import models.Account;
import services.AccountService;

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
        String sql = "DELETE FROM account WHERE id = ?";

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
                a.setEmail(resultSet.getString("full_name"));
                a.setFull_name(resultSet.getString("full_name"));
                a.setFull_name(resultSet.getString("full_name"));

                acc.add(a);

            }

            System.out.println("--correct find");
            return acc;

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
            return null;
        }
    }
}
