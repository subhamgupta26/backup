package com.psl.bean;

import java.sql.Date;

public class Friend extends Contact {

	private String petName;

	public Friend() {
		super();
	}

	

	public Friend(String firstName, String lastName, String email,
			Date dateOfBirth, Address address, String petName) {
		super(firstName, lastName, email, dateOfBirth, address);
		this.petName = petName;
	}



	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
}
