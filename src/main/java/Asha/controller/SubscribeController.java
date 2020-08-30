package Asha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Asha.entity.UserRegistrationEntity;
import Asha.service.MailSender;
import Asha.service.UserRegistrationService;

public class SubscribeController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession ses = request.getSession(false);
		 UserRegistrationEntity ure = new UserRegistrationEntity();
		 UserRegistrationService urs = new UserRegistrationService();
		 
		 ure = urs.getUserEntity((String)ses.getAttribute("username"));
		 
		 String usermail = ure.email;
		 MailSender mail = new MailSender();
		 String msg= "Hello Sir, your had subscribed to our website" ;
		 mail.send(usermail, "Asha", msg);
	
		 urs.saveChanges(ure);
		 
		 response.sendRedirect("/profilepage.jsp");
	
	}

}
