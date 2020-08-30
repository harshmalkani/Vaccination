package Asha.controller;

import java.io.IOException;
import org.joda.time.*;

import Asha.entity.ChildInformationEntity;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetChildSchedular extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
 		
		HttpSession ses = request.getSession(false);
		String dateofbirth = null;

			
	   dateofbirth = ((ChildInformationEntity) ses.getAttribute("childentity")).dateofbirth;
			
		
			
		
		String month = dateofbirth.substring(5, 7);
		String year = dateofbirth.substring(0,4);
		String day = dateofbirth.substring(8);
		
		int birth_day =Integer.parseInt(day);
		int birth_month =Integer.parseInt(month);
		int birth_year =Integer.parseInt(year);
		
		
		LocalDate dob = new LocalDate(birth_year, birth_month, birth_day);  // Date of Birth Object
		LocalDate localDate = LocalDate.now();                          //Current Date
		
		
		ses.setAttribute("dateofbirth", dob);
		ses.setAttribute("currentdate", localDate);
		response.sendRedirect("Schedule.jsp");
		}
		
		
		
		
	}


