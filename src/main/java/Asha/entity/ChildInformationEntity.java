package Asha.entity;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class ChildInformationEntity implements Serializable {

	@Id public String parent_name;
	public String child_name;
	@Index public String dateofbirth;
	public String parent_email;
	
	public ChildInformationEntity() {}
	public ChildInformationEntity(String username, String name, String dob,String email) {
		parent_email = email;
		parent_name = username;
		child_name = name;
		dateofbirth = dob;
	}
	
}
