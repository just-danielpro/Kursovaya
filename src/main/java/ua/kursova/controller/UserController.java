package ua.kursova.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import ua.kursova.models.User;

public class UserController {

	private Connection conn;
	private Statement st;
	private String salt = "Pasha Loh";
	public UserController() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		}
		System.out.print("Connection.....");
		try {
			ResourceBundle config = ResourceBundle.getBundle("connection");
			conn = DriverManager.getConnection("jdbc:mysql://" + config.getString("host") + "/" + config.getString("db")
					+ "?" + "user=" + config.getString("user") + "&password=" + config.getString("psw"));
			System.out.println("obtained");
			st = conn.createStatement();
		} catch (SQLException ex) {
			System.out.println("failed...");
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	private String hashString(String hash) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(hash));
		return String.format("%032x", new BigInteger(md5.digest()));
	}
	public void insert(String email, String password, String name, String surName, String age, String gender,
			String position,String city) {
		try {
			Statement st = conn.createStatement();
			String query = "INSERT INTO user(email,password,name,surname,age,gender,position,city) VALUES("+"'"+email+"',"+"'"+hashString(password+salt)+"',"
					+ "'"+name+"',"+"'"+surName+"',"+"'"+age+"',"+"'"+gender+"',"+"'"+position+"',"+"'"+city+"'"+");";
			st.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public boolean checkEmail(String email) {
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT email FROM user WHERE email='"+email+"';");
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User checkUser(String email, String password) 
	{
		Statement st;
		User user = null;
		if(checkEmail(email) == true) 
		{
			System.out.println("FIRST CHECK");
			try {
				st = conn.createStatement();
				ResultSet rs= st.executeQuery("SELECT * FROM user WHERE email='"+email+"';");
				if(rs.next()) 
				{
					System.out.println("SECOND CHECK");
					if(rs.getString("password").equals(hashString(password+salt))) 
					{
						System.out.println("CREAT USER");
						user = getUser(rs.getInt("id"));
						return user;
					}else
						return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return user;
	}
	

	public User getUser(int id) {
		User user = new User();
		PreparedStatement pr;
		try {
			pr = conn.prepareStatement("SELECT * FROM user WHERE id =" + id);
			ResultSet rs = pr.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setSurName(rs.getString("surname"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setPosition(rs.getString("position"));
				user.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public static void logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		if (request.getParameter("logout") != null) {
			if (session != null) {
				session.invalidate();
				try {
					response.sendRedirect(request.getContextPath() + "/MainServlet");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else
			return;
	}
	
	
	
}
	
