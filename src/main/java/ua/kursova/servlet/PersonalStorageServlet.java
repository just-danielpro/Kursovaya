package ua.kursova.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.kursova.controller.SummeryController;
import ua.kursova.controller.UserController;
import ua.kursova.controller.UserEmployerController;
import ua.kursova.controller.VacationController;
import ua.kursova.models.Summery;
import ua.kursova.models.User;
import ua.kursova.models.UserEmployer;
import ua.kursova.models.Vacation;


public class PersonalStorageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PersonalStorageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserController uc = new UserController();
		UserEmployerController uec = new UserEmployerController();
		SummeryController sc = new SummeryController();
		VacationController vc = new VacationController();
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/personalStoragePage.jsp");
		if(session.getAttribute("user")!=null) 
		{
			User user = (User) session.getAttribute("user");
				List<Summery>list = sc.showAllSummerysById(user.getId());
				if(list.size() > 0) 
				{
					request.setAttribute("list", list);
					UserController.logout(request, session,response);
				}
		}else 
		{
			UserEmployer user = (UserEmployer) session.getAttribute("userEmployer");
			List<Vacation>list = vc.showAllVacationById((user.getId()));
			if(list.size() > 0) 
			{
				request.setAttribute("list", list);
				UserController.logout(request, session,response);
			}
		}
		
		request.setAttribute("session", session);
		try {
			rd.forward(request, response);
		} catch (IllegalStateException ex) {
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
