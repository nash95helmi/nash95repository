package org.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.model.User;
import org.util.DBUtil;

public class UserRepository {
	
	/**
	 * Insert new record
	 * @param user
	 * @return
	 */
	public static int addUser(User user) {
		String query = "insert into users (pasword, fname, lname, email) values ( ?,?,?,? )";
		int result = -1;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, user.getPassword());
			st.setString(2, user.getFirstname());
			st.setString(3, user.getLastname());
			st.setString(4, user.getEmail());
			
			result = st.executeUpdate();
		}catch(SQLException se) {
			//error for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//error for this class
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * Get all available user from DB
	 */
	public static List<User> getAllUser() {
		String query = "select userid,pasword, fname, lname, email from users";
		int i = 0;
		List<User> userList = new ArrayList<User>();
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
//			Statement stmt = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				User newUser = new User();
				newUser.setUserId(rs.getInt("userid"));
				newUser.setPassword(rs.getString("pasword"));
				newUser.setFirstname(rs.getString("fname"));
				newUser.setLastname(rs.getString("lname"));
				newUser.setEmail(rs.getString("email"));
				
				userList.add(newUser);
			}
			
		}catch(SQLException se) {
			
		}catch(Exception e) {
			
		}
		return userList;
	}
	
	
	/**
	 * get UserID
	 * @param user
	 */
	public static int getUserID(User user) {
		System.out.println("userID from UR "+user.getUserId());
		int id = user.getUserId();
		String query = "select *  from users where userid="+id; 
		int result = 0;
		
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = conn.prepareStatement(query);	
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				user.setUserId(rs.getInt("userid"));
				user.setPassword(rs.getString("pasword"));
				user.setFirstname(rs.getString("fname"));
				user.setLastname(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
			}

		}catch(SQLException se) {
			//error for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//error for this class
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	/**
	 * Edit existing user
	 * @param user
	 */
	public static void editUser(User user) {
		String query = "update users set pasword=?,fname=?,lname=?,email=? where userid=?";
		int result = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, user.getPassword());
			st.setString(2, user.getFirstname());
			st.setString(3, user.getLastname());
			st.setString(4, user.getEmail());
			st.setInt(5, user.getUserId());
			
			result = st.executeUpdate();
		}catch(SQLException se) {
			//error for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//error for this class
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Delete existing user
	 * @param user
	 */
	public static void deleteUser(User user) {
		String query = "delete from users where userid=?";
		int result = 0;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, user.getUserId());
			
			result = st.executeUpdate();
		}catch(SQLException se) {
			//error for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//error for this class
			e.printStackTrace();
		}
	}
}
