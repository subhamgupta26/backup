package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Qualification {

	private int qualificationId;
	private String name;
	private Set<Profile> profiles=new HashSet<Profile>();
	public Qualification() {
		super();
	}
	public Qualification(String name) {
		super();
		this.name = name;
	}
	public int getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	
}
