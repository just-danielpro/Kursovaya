package ua.kursova.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.SummeryController;
import ua.kursova.controller.UserController;
import ua.kursova.controller.VacationController;
import ua.kursova.models.User;
import ua.kursova.models.UserEmployer;

/**
 * Servlet implementation class VacationServlet
 */
public class VacationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VacationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/summeryBuilderPage.jsp");
		request.setAttribute("form", true);
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
		String title = request.getParameter("title");
		String description = request.getParameter("desc");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/vacationBuildPage.jsp");
		VacationController vc = new VacationController();
		HttpSession session = request.getSession();
		boolean error = false;
		StringBuilder errorText = new StringBuilder("<font color = 'red'> <ul>");
		if (title.length() == 0) 
		{
			error = true;
			errorText.append("<li>Title empty</li>");
		}
		if (description.length() == 0) 
		{
			error = true;
			errorText.append("<li>Desc empty</li>");
		}
		if(error) 
		{
			request.setAttribute("errorText", errorText);
			request.setAttribute("form", true);
			request.setAttribute("error", true);
			request.setAttribute("title", title);
			request.setAttribute("desc", description);
		}else 
		{
			request.setAttribute("form", false);
			UserEmployer user = (UserEmployer) session.getAttribute("userEmployer");
			vc.insert(title, description, user.getId());
		}
		
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
