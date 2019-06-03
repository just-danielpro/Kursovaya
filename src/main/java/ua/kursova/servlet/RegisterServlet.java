package ua.kursova.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.UserController;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean form = true;
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registerPage.jsp");
		request.setAttribute("form", form);
		request.setAttribute("session", session);
		UserController.logout(request, session,response);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserController uc = new UserController();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registerPage.jsp");
		String email = request.getParameter("login");
		String name = request.getParameter("name");
		String surName = request.getParameter("surName");
		String password = request.getParameter("password");
		String repassword = request.getParameter("confirmPassword");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String position = request.getParameter("worker");
		boolean form = true;
		boolean error = false;
		StringBuilder errorText = new StringBuilder("<font color = 'red'> <ul>");
		if (email != null) {
			if (email.length() == 0) {
				error = true;
				errorText.append("<li>Email empty</li>");
			}
			if (name.length() == 0) {
				error = true;
				errorText.append("<li>Name empty</li>");
			}
			if (surName.length() == 0) {
				error = true;
				errorText.append("<li>Surname empty</li>");
			}
			if (password.length() == 0) {
				error = true;
				errorText.append("<li>Password empty</li>");
			}
			if (repassword.length() != 0 && !repassword.equals(password)) {
				error = true;
				errorText.append("<li>Repassword don't match</li>");
			}
			if (age.length() == 0) {
				error = true;
				errorText.append("<li>Age empty</li>");
			}
			if (age.length() != 0 && Integer.parseInt(age) < 0) {
				error = true;
				errorText.append("<li>Age invalid value</li>");
			}
			if (gender == null || gender.length() == 0) {
				error = true;
				errorText.append("<li>Gender empty</li>");
			}
			if (city.length() == 0) {
				error = true;
				errorText.append("<li>Address empty</li>");
			}
			if (position == null || position.length() == 0) {
				error = true;
				errorText.append("<li>Position not selected</li>");
			}
			if (!uc.checkEmail(email)) {
				errorText.append("<li>Such email already exists</li>");
				error = true;
			}
			if (error) {
				form = true;
				errorText.append("</ul>");
				request.setAttribute("email", email);
				request.setAttribute("name", name);
				request.setAttribute("surName", surName);
				request.setAttribute("age", age);
				request.setAttribute("gender", gender);
				if (gender != null) {
					request.setAttribute("genderM", gender.equals("M") ? "checked" : "");
					request.setAttribute("genderF", gender.equals("F") ? "checked" : "");
				}
				request.setAttribute("city", city);
				if(city != null) {
					request.setAttribute("address1", (Integer.parseInt(city)) == 1 ? "selected" : "");
					request.setAttribute("address2", (Integer.parseInt(city)) == 2 ? "selected" : "");
					request.setAttribute("address3", (Integer.parseInt(city)) == 3 ? "selected" : "");
					request.setAttribute("address4", (Integer.parseInt(city)) == 4 ? "selected" : "");
					request.setAttribute("address5", (Integer.parseInt(city)) == 5 ? "selected" : "");
					request.setAttribute("address6", (Integer.parseInt(city)) == 6 ? "selected" : "");
					request.setAttribute("address7", (Integer.parseInt(city)) == 7 ? "selected" : "");
					request.setAttribute("address8", (Integer.parseInt(city)) == 8 ? "selected" : "");
					request.setAttribute("address9", (Integer.parseInt(city)) == 9 ? "selected" : "");
				}
				request.setAttribute("errorText", errorText.toString());
				request.setAttribute("isError", error);
				request.setAttribute("form", form);
			} else {
				form = false;
				uc.insert(email, password, name,surName,age, gender, position,city);
				boolean thankful = true;
				request.setAttribute("thanks","Thanks for your register");
				request.setAttribute("thankful", true);
				
			}
			HttpSession session = request.getSession();
			UserController.logout(request, session,response);
			request.setAttribute("session", session);
			try 
			{
				rd.forward(request, response);
			}catch(Exception e) 
			{
				e.printStackTrace();
			}
	}

}
}
