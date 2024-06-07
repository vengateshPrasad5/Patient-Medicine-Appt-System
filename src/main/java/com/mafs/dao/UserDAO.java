package com.mafs.dao;

import com.mafs.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User user) {

		boolean transaction = false;

		try {
			// insert user in db
			String sql = "insert into user(full_name, email, password) values(?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getFullName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());

			pstmt.executeUpdate();

			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return transaction;
	}

	public User loginUser(String email, String password) {

		User user = null;

		try {
			String sql = "select * from user where email=? and password=?";

			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet resultSet = pstmt.executeQuery();
			while (resultSet.next()) {

				// create new user object
				user = new User();

				user.setId(resultSet.getInt("id"));
				user.setFullName(resultSet.getString("full_name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;

	}

	//check old password
	public boolean checkOldPassword(int userId, String oldPassword) {

		boolean transaction = false;

		try {

			String sql = "select * from user where id=? and password=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, oldPassword);

			ResultSet resultSet = pstmt.executeQuery();
			//System.out.println(resultSet);
			while (resultSet.next()) {
				transaction = true;
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

	//change password
	public boolean changePassword(int userId, String newPassword) {

		boolean transaction = false;

		try {

			String sql = "update user set password=? where id=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setInt(2, userId);

			pstmt.executeUpdate();

			transaction = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transaction;
	}

}
