package com.uyen.crm.repository;

import com.uyen.crm.config.MysqlConnection;
import com.uyen.crm.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();
        try {
            String query = "select * from roles";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setDescription(resultSet.getString("description"));
                list.add(role);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error getRoles" + e.getMessage());
        }
        return list;
    }

    public int deleteRepository(int Id) {
        int result = 0;
        try {
            String query = "delete from roles r where r.id = ?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Id);
            result = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error delete role by ID" + e.getMessage());
        }
        return result;
    }

    public int addRole(String name, String description){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
    try {
            String query = "INSERT INTO roles(name, description) VALUES (?,?)";
            connection = MysqlConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            result = preparedStatement.executeUpdate();
            System.out.println("adding successfully");
            connection.close();
        }catch (Exception e){
            System.out.println("Error in adding role, " +e.getMessage());
        }
        return result;
    }
}
