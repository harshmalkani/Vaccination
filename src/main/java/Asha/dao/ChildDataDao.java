package Asha.dao;

import static Asha.service.OfyService.ofy;

import java.util.Iterator;
import java.util.List;

import com.googlecode.objectify.cmd.Query;

import Asha.entity.ChildInformationEntity;
import Asha.service.OfyService;

public class ChildDataDao {


	public void enterChildData(ChildInformationEntity cie) {

		ofy().save().entity(cie).now();
		
	}

	public ChildInformationEntity getChildData(String username) {

		ChildInformationEntity cie = ofy().load().type(ChildInformationEntity.class).id(username).now();
		
		return cie;
	}

	public List<ChildInformationEntity> allChildData() {

		List<ChildInformationEntity> clist = ofy().load().type(ChildInformationEntity.class).list();
		return clist;
	}


}
