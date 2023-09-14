package repository;

import db.MySqlConnection;
import models.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    private static Connection connection = MySqlConnection.createConnection();
    public void create(Role role){
        String sql = "INSERT INTO account VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, role.getRole_id());
            preparedStatement.setString(2, role.getRole_name());
            preparedStatement.setString(3, role.getDescription());
            preparedStatement.setInt(4, role.getStatus());

            preparedStatement.executeUpdate();

            System.out.println("--correct insert on database");

        } catch(SQLException e) {
            System.out.println("--incorrect insert on database. " + e.getMessage());
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM role WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();

            System.out.println("--correct delete ");

        } catch (SQLException e) {
            System.out.println("--incorrect delete . " + e.getMessage());
        }
    }

    public List<Role> getAll() {

        String  sql = "SELECT * FROM role";
        List<Role> role = new ArrayList<Role>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                Role r = new Role();

                r.setRole_id(resultSet.getString("role_id"));
                r.setRole_name(resultSet.getString("role_name"));
                r.setDescription(resultSet.getString("description"));
                r.setStatus(Integer.parseInt(resultSet.getString("status")));

                role.add(r);

            }

            System.out.println("--correct find");
            return role;

        } catch (SQLException e) {
            System.out.println("--incorrect find. " + e.getMessage());
            return null;
        }
    }
}
