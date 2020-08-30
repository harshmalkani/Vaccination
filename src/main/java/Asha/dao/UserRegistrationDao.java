package Asha.dao;

import Asha.entity.UserRegistrationEntity;
import static Asha.service.OfyService.ofy;

public class UserRegistrationDao {
	
	public static String pword;

	public boolean check(String username) {
		
	   UserRegistrationEntity ure = ofy().load().type(UserRegistrationEntity.class).id(username).now();
	   if(ure != null)
	   {
		   pword = ure.password;
		   return true;
	   }
		return false;
	}

	public void register(UserRegistrationEntity ure) {
		 
		ofy().save().entity(ure).now();
		
	}

	public UserRegistrationEntity getEntity(String username) {
		UserRegistrationEntity ure = ofy().load().type(UserRegistrationEntity.class).id(username).now();
		return ure;
	}

}
