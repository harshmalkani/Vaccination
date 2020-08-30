package Asha.service;

import Asha.dao.UserRegistrationDao;
import Asha.entity.UserRegistrationEntity;

public class UserRegistrationService {

	UserRegistrationDao urd = new UserRegistrationDao();
	public boolean CheckForUserExistance(String username) {

		return urd.check(username);
		
	}
	public UserRegistrationEntity getUserEntity(String username)
	{
		return urd.getEntity(username);
	}
	public void register(String email, String name, String username, String password, String phone_number) {
		
		UserRegistrationEntity ure = new UserRegistrationEntity(email, name, username, password,phone_number);
		urd.register(ure);
		
	}
   public void saveChanges(UserRegistrationEntity ure) {
		
		urd.register(ure);
		
	}

}
