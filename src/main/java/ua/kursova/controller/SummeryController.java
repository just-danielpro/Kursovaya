package ua.kursova.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import ua.kursova.models.Summery;



public class SummeryController {

	private Connection conn;
	private Statement st;
	public SummeryController() 
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
			String INSERT = "INSERT INTO summery(name,description,user_id) VALUES (" + "'"+title+"',"+"'"+description+"',"+user_id+");";
			st.executeUpdate(INSERT);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void deleteSummeryById(int id) 
	{
		String delete_by_id = "DELETE FROM kursova.summery WHERE summery.id ="+id+";";
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(delete_by_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Summery getSummeyById(int id) 
	{
		Statement st = null;
		Summery summery = null;
		try {
			ResultSet rs = st.executeQuery("SELECT * FROM summery WHERE user_id ="+id);
			if(rs.next()) 
			{
				summery = new Summery(rs.getInt("id"),rs.getString("name"),rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summery;
	}
	public   List<Summery> showAllSummerysById(int id)
	{
		String GET_ALL_SUMMERRYS_BY_ID = "SELECT * FROM summery WHERE user_id ="+id;
		List<Summery>list = new ArrayList<>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(GET_ALL_SUMMERRYS_BY_ID);
			while(rs.next()) 
			{
				list.add(new Summery(rs.getInt("id"),rs.getString("name"),rs.getString("description")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
				
	}
}
