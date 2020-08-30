package Asha.entity;


import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class UserRegistrationEntity implements Serializable{


	@Id String username;
	@Index public String name;
	public String email;
	public String password;
	public String phone_number;
	public String profile_pic;
	public String user_feed;
	public boolean subscribe;

	public UserRegistrationEntity() {}
	public UserRegistrationEntity(String email,String name,String username,String password,String phone_number) {
		
		this.email = email;
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		subscribe = false;
		
	}
	
}
