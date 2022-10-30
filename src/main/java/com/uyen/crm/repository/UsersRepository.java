package com.uyen.crm.repository;

import com.uyen.crm.config.MysqlConnection;
import com.uyen.crm.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
	public List<Users> getUserByEmailAndPassword(String email, String password) {
		List<Users> list = new ArrayList<>();
		try {
			String query = "select * from users u where u.email =? and u.password =?";
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Users users = new Users();
				users.setId(resultSet.getInt("id"));
				users.setEmail(resultSet.getString("email"));
				users.setAvatar(resultSet.getString("avatar"));
				users.setFullName(resultSet.getString("fullName"));
				users.setRoleId(resultSet.getInt("role_id"));
				list.add(users);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error getUserByEmailAndPassword " + e.getMessage());
		}
		return list;
	}

	public String getUserRoleByRoleId(int roleId) {
		String role = null;
		try {
			String query = "SELECT name FROM roles WHERE id = ?;";
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, roleId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				role = resultSet.getString("name");
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error getUsers" + e.getMessage());
		}
		return role;
	}

	public List<Users> getUsers() {
		List<Users> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM users;";
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Users user = new Users();
				user.setId(resultSet.getInt("id"));
				user.setFullName(resultSet.getString("fullname"));
				user.setEmail(resultSet.getString("email"));
				user.setRoleId(resultSet.getInt("role_id"));
				user.setAvatar(resultSet.getString("avatar"));
				list.add(user);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error getUsers" + e.getMessage());
		}
		return list;
	}

	public boolean updateUser(Users user) {
		try {
			String query = "UPDATE users SET email = '?', fullname = '?', avatar = '?', role_id = '?' WHERE id = ?;";
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getFullName());
			statement.setString(3, user.getAvatar());
			statement.setInt(4, user.getRoleId());
			statement.setInt(5, user.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error updateUser" + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean deleteUser(int id) {
		try {
			String query = "DELETE FROM users WHERE id = ?";
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error deleteUser" + e.getMessage());
			return false;
		}
		return true;
	}
}
