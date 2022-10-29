package com.uyen.crm.repository;

import com.uyen.crm.config.MysqlConnection;
import com.uyen.crm.model.Role;
import com.uyen.crm.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    public List<Users> getUserByEmailAndPassword(String email, String password){
        List<Users> list = new ArrayList<>();
        try {
            String query = "select * from users u where u.email =? and u.password =?";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Users users = new Users();
                users.setId(resultSet.getInt("id"));
                users.setEmail(resultSet.getString("email"));
                users.setAvatar(resultSet.getString("avatar"));
                users.setFullName(resultSet.getString("fullName"));
                users.setRoleId(resultSet.getInt("role_id"));
                list.add(users);
            }
            connection.close();
        }catch (Exception e){
            System.out.println("Error getUserByEmailAndPassword "+e.getMessage());
        }
        return list;
        }

    public List<Users> getUsers() {
        List<Users> list = new ArrayList<>();
        try {
            String query = "select * from users";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("fullname"));
                user.setAvatar(resultSet.getString("avatar"));
                user.setRoleId(resultSet.getInt("role_id"));
                list.add(user);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error get all user" + e.getMessage());
        }
        return list;
    }
}
