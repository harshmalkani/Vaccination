package Asha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Asha.entity.UserRegistrationEntity;
import Asha.service.MailSender;
import Asha.service.UserRegistrationService;


public class ForgetPasswordController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String un= request.getParameter("uname");
		 UserRegistrationEntity ure = new UserRegistrationEntity();
		 UserRegistrationService urs = new UserRegistrationService();
		 
		 ure = urs.getUserEntity(un);
		 
		 String usermail = ure.email;
		 
			
		 MailSender mail = new MailSender();
		 String msg= "Hello Sir, your password is "+ ure.password ;
		 mail.send(usermail, "Asha", msg);
	
		 response.sendRedirect("index.html");
	}

}
