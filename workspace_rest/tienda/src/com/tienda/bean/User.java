package com.tienda.bean;

import java.util.Set;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="user")
public class User {

	private int userId;
	private String email,username;
	private Set<Link> links;
	public User() {
		super();
	}
	public User(int userId, String username, String email) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@XmlElementWrapper(name="links")
	@XmlElementRef
	public Set<Link> getLinks() {
		return links;
	}
	public void setLinks(Set<Link> links) {
		this.links = links;
	}
	
}
