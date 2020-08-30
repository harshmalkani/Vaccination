package Asha.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.objectify.annotation.Index;

import Asha.entity.ChildInformationEntity;
import Asha.entity.UserRegistrationEntity;
import Asha.service.ChildDataEntryService;
import Asha.service.MailSender;
import Asha.service.UserRegistrationService;

public class RegistrationController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("register-form-name");
		
		String email = request.getParameter("register-form-email");
		String username = request.getParameter("register-form-username");
		String phone_number = request.getParameter("register-form-phone");
		String password = request.getParameter("register-form-password");
		String childname = request.getParameter("register-form-childname");
		String dateofbirth = request.getParameter("register-form-dateofbirth");
		email = email.trim();
		username = username.trim();
		childname = childname.trim();
		name = name.trim();
		
		UserRegistrationService urs = new UserRegistrationService();
		ChildDataEntryService cdes = new ChildDataEntryService();
		
	   if(urs.CheckForUserExistance(username))
	   {
		   response.sendRedirect("user-registration.html");
	   }
	   else 
	   {
		  
		   urs.register(email, name, username, password,phone_number);
		   cdes.childDataEntry(username, childname, dateofbirth, email);
		   UserRegistrationEntity ure = urs.getUserEntity(username);
		   ChildInformationEntity cie = cdes.getChildEntity(username);
		   
		   String reciever_email_id = cie.parent_email;
			MailSender mail = new MailSender();
		    String msg= "Congratulation, " +ure.name+ "! You have successfully enrolled. ";
			mail.send(reciever_email_id, "Asha", msg);
			
		   HttpSession ses= request.getSession();
		   ses.setAttribute("username", username);
		   ses.setAttribute("parententity", ure);
		   ses.setAttribute("childentity", cie);
		   response.sendRedirect("profilepage.jsp");
	   }
	
	}
}
