package ua.kursova.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.UserController;
import ua.kursova.controller.VacationController;
import ua.kursova.models.Vacation;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/mainPage.jsp");
		HttpSession session = request.getSession();
		String str ="";
		UserController.logout(request, session,response);
			if(request.getParameter("t1")!=null)
			str = request.getParameter("t1");
		VacationController vc = new VacationController();
			if(str.length() != 0) 
			{
				List<Vacation>list = vc.showAllVacationByName((str));
				
				request.setAttribute("listVacation", list);
			}
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
		
	}

}
