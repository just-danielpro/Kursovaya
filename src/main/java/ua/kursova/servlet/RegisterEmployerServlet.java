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
import ua.kursova.controller.UserEmployerController;

/**
 * Servlet implementation class RegisterEmployerServlet
 */
public class RegisterEmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEmployerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean form = true;
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registerEmployerPage.jsp");
		request.setAttribute("form", form);
		UserController.logout(request, session,response);
		request.setAttribute("session", session);
		try {
			rd.forward(request, response);
		} catch (IllegalStateException ex) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserEmployerController uec = new UserEmployerController();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registerEmployerPage.jsp");
		String email = request.getParameter("login");
		String name = request.getParameter("name");
		String surName = request.getParameter("surName");
		String password = request.getParameter("password");
		String repassword = request.getParameter("confirmPassword");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String companyName = request.getParameter("companyName");
		String companyMobile = request.getParameter("companyMobile");
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
			if (companyName.length() == 0) {
				error = true;
				errorText.append("<li>Company name empty</li>");
			}
			if (companyMobile.length() == 0) {
				error = true;
				errorText.append("<li>Company mobile empty</li>");
			}
			if (uec.checkEmail(email)) {
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
					request.setAttribute("address1", city.equals("Kyiv") ? "selected" : "");
					request.setAttribute("address2", city.equals("Poltava") ? "selected" : "");
					request.setAttribute("address3", city.equals("Odesa") ? "selected" : "");
					request.setAttribute("address4", city.equals("Zhytomyr") ? "selected" : "");
					request.setAttribute("address5", city.equals("Dnipro")? "selected" : "");
					request.setAttribute("address6", city.equals("Lviv")? "selected" : "");
					request.setAttribute("address7", city.equals("Kharkov") ? "selected" : "");
					request.setAttribute("address8", city.equals("Rovno")? "selected" : "");
					request.setAttribute("address9", city.equals("Mariupol")? "selected" : "");
				}
				request.setAttribute("errorText", errorText.toString());
				request.setAttribute("isError", error);
				request.setAttribute("form", form);
			} else {
				form = false;
					uec.insertEmployer(email, password, name,surName,age, gender, "Employer",city,companyName,companyMobile);
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
