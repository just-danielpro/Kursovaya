package ua.kursova.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ua.kursova.models.Vacation;



public class VacationController {

	private Connection conn;
	private Statement st;
	public VacationController() 
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
	
	public void insert(String title, String description, int user_id) 
	{
		try {
			Statement st = conn.createStatement();
			String INSERT = "INSERT INTO vacation(name,description,user_id) VALUES (" + "'"+title+"',"+"'"+description+"',"+user_id+");";
			st.executeUpdate(INSERT);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public Vacation getVacationById(int id) 
	{
		Statement st = null;
		Vacation summery = null;
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM vacation WHERE user_id ="+id);
			if(rs.next()) 
			{
				summery = new Vacation(rs.getInt("id"),rs.getString("name"),rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summery;
	}
	public   List<Vacation> showAllVacationById(int id)
	{
		String GET_ALL_SUMMERRYS_BY_ID = "SELECT * FROM vacation WHERE user_id ="+id;
		List<Vacation>list = new ArrayList<>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(GET_ALL_SUMMERRYS_BY_ID);
			while(rs.next()) 
			{
				list.add(new Vacation(rs.getInt("id"),rs.getString("name"),rs.getString("description")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
				
	}
}
