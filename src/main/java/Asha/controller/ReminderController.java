package Asha.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.Days;
import org.joda.time.LocalDate;

import Asha.entity.ChildInformationEntity;
import Asha.service.ChildDataEntryService;
import Asha.service.MailSender;

public class ReminderController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LocalDate lDate = LocalDate.now();
	    
		ChildDataEntryService cdrs = new ChildDataEntryService();
		List<ChildInformationEntity> lis = cdrs.listOfAllChild();
		Iterator<ChildInformationEntity> itre = lis.iterator();
		String dateofbirth;
		LocalDate dob,dd;
		String reciever_email_id;
		MailSender mail;
		String msg;
		
		ChildInformationEntity cie;
		
		while(itre.hasNext())
		{
			 cie = itre.next();
			 dateofbirth = cie.dateofbirth;
			 String month = dateofbirth.substring(5, 7);
			 String year = dateofbirth.substring(0,4);
			 String day = dateofbirth.substring(8);
			
			 int birth_day =Integer.parseInt(day);
			 int birth_month =Integer.parseInt(month);
			 int birth_year =Integer.parseInt(year);
			
			
			 dob = new LocalDate(birth_year, birth_month, birth_day);
			 dd=dob;
			 
			 int age = Days.daysBetween(dob,lDate).getDays();
			 
			 switch(age)
			 {
			 
			 case 0: reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 2 vaccination today. First one B.C.G and another one Hep-B1(after 24 hr) vaccination." ;
					mail.send(reciever_email_id, "Asha", msg);
				 
				      break;
			 case 6:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of DTP 1." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 12:  reciever_email_id = cie.parent_email;
					
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of IPV 1." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 18:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of HEP - B2." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 24:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hib-1." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 30:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Rotavirus 1." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 36:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of PCV 1." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 70:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of DTP 2." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 76:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of IPV 2." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 82:  reciever_email_id = cie.parent_email;
				
					 mail = new MailSender();
					 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hib 2." ;
					mail.send(reciever_email_id, "Asha", msg);
			 
			      break;
			 case 88:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Rotavirus 2." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 94:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of PCV 2." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 98:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of DTP 3." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 104:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of IPV 3." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 110:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hib 3." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 116:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Rotavirus 3." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
			 case 122:  reciever_email_id = cie.parent_email;
				
			 mail = new MailSender();
			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of PCV 3." ;
			mail.send(reciever_email_id, "Asha", msg);
	 
	      break;
	      
	      default:
	    	  dob = dob.plusMonths(6);
	    	  if(lDate.compareTo(dob) == 0)
	    	  {    
	    		  reciever_email_id = cie.parent_email;
					
	 			 mail = new MailSender();
	 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of OPV 1." ;
	 			mail.send(reciever_email_id, "Asha", msg);
	    	  }
	    	  else 
	    	  {
	    		  dob = dob.plusMonths(1);
	    		  if(lDate.compareTo(dob) == 0)
		    	  {    
		    		  reciever_email_id = cie.parent_email;
						
		 			 mail = new MailSender();
		 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hep - B3." ;
		 			mail.send(reciever_email_id, "Asha", msg);
		    	  }
	    		  else 
		    	  {
		    		  dob = dob.plusMonths(2);
		    		  if(lDate.compareTo(dob) == 0)
			    	  {    
			    		  reciever_email_id = cie.parent_email;
							
			 			 mail = new MailSender();
			 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of OPV 2." ;
			 			mail.send(reciever_email_id, "Asha", msg);
			    	  }
		    		  else 
			    	  {
			    		  dob = dob.plusMonths(1);
			    		  if(lDate.compareTo(dob) == 0)
				    	  {    
				    		  reciever_email_id = cie.parent_email;
								
				 			 mail = new MailSender();
				 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Measles." ;
				 			mail.send(reciever_email_id, "Asha", msg);
				    	  }
			    		  else 
				    	  {
				    		  dob = dob.plusMonths(2);
				    		  if(lDate.compareTo(dob) == 0)
					    	  {    
					    		  reciever_email_id = cie.parent_email;
									
					 			 mail = new MailSender();
					 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hep - A1." ;
					 			mail.send(reciever_email_id, "Asha", msg);
					    	  }
				    		  else 
					    	  {
					    		  dob = dob.plusMonths(3);
					    		  if(lDate.compareTo(dob) == 0)
						    	  {    
						    		  reciever_email_id = cie.parent_email;
										
						 			 mail = new MailSender();
						 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of MMR 1." ;
						 			mail.send(reciever_email_id, "Asha", msg);
						    	  }
					    		  else 
						    	  {
						    		  dob = dob.plusDays(12);
						    		  if(lDate.compareTo(dob) == 0)
							    	  {    
							    		  reciever_email_id = cie.parent_email;
											
							 			 mail = new MailSender();
							 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Varicella 1." ;
							 			mail.send(reciever_email_id, "Asha", msg);
							    	  }
						    		  else 
							    	  {
							    		  dob = dob.plusDays(12);
							    		  if(lDate.compareTo(dob) == 0)
								    	  {    
								    		  reciever_email_id = cie.parent_email;
												
								 			 mail = new MailSender();
								 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of PCV Booster." ;
								 			mail.send(reciever_email_id, "Asha", msg);
								    	  }
							    		  else 
								    	  {
								    		  dob = dd.plusMonths(16);
								    		  if(lDate.compareTo(dob) == 0)
									    	  {    
									    		  reciever_email_id = cie.parent_email;
													
									 			 mail = new MailSender();
									 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of DTP B1." ;
									 			mail.send(reciever_email_id, "Asha", msg);
									    	  }
								    		  else 
									    	  {
									    		  dob = dob.plusDays(24);
									    		  if(lDate.compareTo(dob) == 0)
										    	  {    
										    		  reciever_email_id = cie.parent_email;
														
										 			 mail = new MailSender();
										 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of IPV B1." ;
										 			mail.send(reciever_email_id, "Asha", msg);
										    	  }
									    		  else 
										    	  {
										    		  dob = dd.plusMonths(17);
										    		  dob = dob.plusDays(18);
										    		  if(lDate.compareTo(dob) == 0)
											    	  {    
											    		  reciever_email_id = cie.parent_email;
															
											 			 mail = new MailSender();
											 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hib B1." ;
											 			mail.send(reciever_email_id, "Asha", msg);
											    	  }
										    		  else 
											    	  {
											    		  dob = dd.plusMonths(18);
											    		  if(lDate.compareTo(dob) == 0)
												    	  {    
												    		  reciever_email_id = cie.parent_email;
																
												 			 mail = new MailSender();
												 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Hep - A2." ;
												 			mail.send(reciever_email_id, "Asha", msg);
												    	  }
											    		  else 
												    	  {
												    		  dob = dd.plusYears(2);
												    		  if(lDate.compareTo(dob) == 0)
													    	  {    
													    		  reciever_email_id = cie.parent_email;
																	
													 			 mail = new MailSender();
													 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Typhoid 1." ;
													 			mail.send(reciever_email_id, "Asha", msg);
													    	  }
												    		  else 
													    	  {
													    		  dob = dob.plusMonths(6);
													    		  if(lDate.compareTo(dob) == 0)
														    	  {    
														    		  reciever_email_id = cie.parent_email;
																		
														 			 mail = new MailSender();
														 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of DTP B2." ;
														 			mail.send(reciever_email_id, "Asha", msg);
														    	  }
													    		  else 
														    	  {
														    		  dob = dd.plusYears(4);
														    		  dob = dob.plusMonths(6);
														    		  if(lDate.compareTo(dob) == 0)
															    	  {    
															    		  reciever_email_id = cie.parent_email;
																			
															 			 mail = new MailSender();
															 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of OPV 3." ;
															 			mail.send(reciever_email_id, "Asha", msg);
															    	  }
														    		  else 
															    	  {
															    		  dob = dob.plusMonths(1);
															    		  if(lDate.compareTo(dob) == 0)
																    	  {    
																    		  reciever_email_id = cie.parent_email;
																				
																 			 mail = new MailSender();
																 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Varicella 2." ;
																 			mail.send(reciever_email_id, "Asha", msg);
																    	  }
															    		  else 
																    	  {
																    		  dob = dob.plusMonths(1);
																    		  if(lDate.compareTo(dob) == 0)
																	    	  {    
																	    		  reciever_email_id = cie.parent_email;
																					
																	 			 mail = new MailSender();
																	 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of MMR 2." ;
																	 			mail.send(reciever_email_id, "Asha", msg);
																	    	  }
																    		  else 
																	    	  {
																	    		  dob = dob.plusMonths(1);
																	    		  if(lDate.compareTo(dob) == 0)
																		    	  {    
																		    		  reciever_email_id = cie.parent_email;
																						
																		 			 mail = new MailSender();
																		 			 msg= "Hello Sir, your child with name "+cie.child_name +" need to be give 1 vaccination today, and that one is of Typhiod 2." ;
																		 			mail.send(reciever_email_id, "Asha", msg);
																		    	  }
																	    	  }
																    	  }
															    	  }
														    	  }
													    	  }
												    	  }
											    	  }
										    	  }
									    	  }
								    	  }
							    		  
							    	  }
						    	  }
					    	  }
				    	  }
			    	  }
		    	  }
	    	  }
	      
	      
	      
	      
	      }
			 
			
		}
	
	
	}

}
