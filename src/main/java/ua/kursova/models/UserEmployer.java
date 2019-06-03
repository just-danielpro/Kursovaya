package ua.kursova.models;

public class UserEmployer{

	private int id;
	private String email;
	private String name;
	private String surName;
	private int age;
	private String gender;
	private String position;
	private String city;
	private String companyName;
	private String companyMobile;
	public UserEmployer(int id, String email, String name, String surName, int age, String gender, String position,
			String city, String companyName, String companyMobile) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.surName = surName;
		this.age = age;
		this.gender = gender;
		this.position = position;
		this.city = city;
		this.companyName = companyName;
		this.companyMobile = companyMobile;
	}
	public UserEmployer() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyMobile() {
		return companyMobile;
	}
	public void setCompanyMobile(String companyMobile) {
		this.companyMobile = companyMobile;
	}
	
	
	
	
}
