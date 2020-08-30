package Asha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Asha.entity.UserRegistrationEntity;
import Asha.service.UserRegistrationService;


public class FillUserFeedback extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession ses = request.getSession(false);
		UserRegistrationEntity ure = (UserRegistrationEntity) ses.getAttribute("parententity");
		
		String feed = request.getParameter("feed");
		
		feed = feed.trim();
		
		ure.user_feed = feed;
		
		UserRegistrationService urs = new UserRegistrationService();
		urs.saveChanges(ure);
		
		response.sendRedirect("profilepage.jsp");
		
	}

}
