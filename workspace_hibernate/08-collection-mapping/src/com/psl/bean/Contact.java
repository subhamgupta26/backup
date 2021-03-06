package com.psl.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact {

	private int contactId;
	private String firstName,lastName;
	private String email;
	private Date dateOfBirth;
	private List<Address> addresses=new ArrayList<Address>();
	private Set<String> mobilenumbers=new HashSet<String>();
	public Contact() {
		super();
	}

	public Contact( String firstName, String lastName,
			String email, Date dateOfBirth) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		
	}


	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setMobilenumbers(Set<String> mobilenumbers) {
		this.mobilenumbers = mobilenumbers;
	}

	public Set<String> getMobilenumbers() {
		return mobilenumbers;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Address> getAddresses() {
		return addresses;
	}
	
	
}
