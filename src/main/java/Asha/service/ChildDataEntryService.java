package Asha.service;

import java.util.List;

import Asha.dao.ChildDataDao;
import Asha.entity.ChildInformationEntity;

public class ChildDataEntryService {
	
	ChildDataDao cdd = new ChildDataDao();

	public void childDataEntry(String username, String childname, String dateofbirth, String email) {
		
		ChildInformationEntity cie = new ChildInformationEntity(username, childname, dateofbirth,email);
		cdd.enterChildData(cie);
		
	}

	public ChildInformationEntity getChildEntity(String username) {
		
		return cdd.getChildData(username);
	}


	public List<ChildInformationEntity> listOfAllChild() {
		return cdd.allChildData();
	}


}
