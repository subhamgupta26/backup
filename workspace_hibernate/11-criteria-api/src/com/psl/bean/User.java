package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class User {

	private int userId;
	private String userName;
	private Set<Account> accounts=new HashSet<Account>();
	public User() {
		super();
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(Account account){
		getAccounts().add(account);
		account.setOwner(this);
	}
}
