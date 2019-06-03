package ua.kursova.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.UserController;
import ua.kursova.controller.UserEmployerController;

/**
 * Servlet implementation class AuthorizationEmployerServlet
 */
public class AuthorizationEmployerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorizationEmployerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		boolean form = true;
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/loginPage2.jsp");
		request.setAttribute("form", form);
		UserController.logout(request, session, response);
		request.setAttribute("session", session);
		try 
		{
			rd.forward(request, response);
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("login");
		String password = request.getParameter("pass");
		System.out.println(email);
		System.out.println(password);
		boolean form = true;
		UserEmployerController uec = new UserEmployerController();
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/loginPage2.jsp");
		session = request.getSession();
		StringBuilder errorText = new StringBuilder("<font color = 'red'> <ul>");
		if(uec.checkUserEmployer(email, password) != null) 
		{
			session.setAttribute("userEmployer", uec.checkUserEmployer(email, password));
			request.setAttribute("session", session);
			request.setAttribute("form", false);
		}
		else
		{
			errorText.append("<li>User not found</li>");
			request.setAttribute("form", true);
			request.setAttribute("errorText", errorText.toString());
		}
		rd.forward(request, response);
	}

}
