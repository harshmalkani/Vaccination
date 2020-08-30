package Asha.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Asha.entity.ChildInformationEntity;
import Asha.entity.UserRegistrationEntity;
import Asha.service.ChildDataEntryService;
import Asha.service.MailSender;
import Asha.service.UserRegistrationService;
import static Asha.dao.UserRegistrationDao.pword;

public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("login-form-username");
		String password = request.getParameter("login-form-password");
		
		username = username.trim();
		
		UserRegistrationService urs = new UserRegistrationService();
		ChildDataEntryService cdrs = new ChildDataEntryService();
		
	   if(urs.CheckForUserExistance(username))
	   {
		   if(pword.equals(password))
		   {
			   UserRegistrationEntity ure = urs.getUserEntity(username);
			   ChildInformationEntity cie = cdrs.getChildEntity(username);
			   
			   HttpSession ses = request.getSession();
			   ses.setAttribute("username", username);
			   ses.setAttribute("parententity", ure);
			   ses.setAttribute("childentity", cie);
			 
			   			  
			   response.sendRedirect("profilepage.jsp");
		   }
		   else
			   response.sendRedirect("user-registration.html");
	   }
	   else 
	   {
		   response.sendRedirect("user-registration.html");
	   }
	
	
	}

}
