package ua.kursova.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.UserController;

/**
 * Servlet implementation class AuthorizationServlet
 */
public class AuthorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		boolean form = true;
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/loginPage.jsp");
		UserController.logout(request, session, response);
		request.setAttribute("form", form);
		request.setAttribute("session", session);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("pass");
		System.out.println(email);
		System.out.println(password);
		boolean form = true;
		UserController uc = new UserController();
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/loginPage.jsp");
		session = request.getSession();
		StringBuilder errorText = new StringBuilder("<font color = 'red'> <ul>");
		if(uc.checkUser(email, password) != null) 
		{
			session.setAttribute("user", uc.checkUser(email, password));
			request.setAttribute("session", session);
			request.setAttribute("form", false);
		}else 
		{
			errorText.append("<li>User not found</li>");
			request.setAttribute("form", true);
			request.setAttribute("errorText", errorText.toString());
		}
		rd.forward(request, response);
	}

}
