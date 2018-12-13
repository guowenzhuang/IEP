package com.ysd.iep.test;

import lombok.Data;

@Data
public class Admin {
	
	String userName;
	Integer age;
	
	public Admin(String userName, Integer age) {
		super();
		this.userName = userName;
		this.age = age;
	}

	public Admin() {
		super();
	}
	
	

}
