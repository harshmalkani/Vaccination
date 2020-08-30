package Asha.service;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

import Asha.entity.ChildInformationEntity;
import Asha.entity.UserRegistrationEntity;

public class OfyService {
	
	static {
		ObjectifyService.register(UserRegistrationEntity.class);
		ObjectifyService.register(ChildInformationEntity.class);
	}
	
	public static Objectify ofy()
	{
		return ObjectifyService.ofy();
	}
	
}
