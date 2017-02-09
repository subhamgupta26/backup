package com.psl.bean;

public class Account {

	private int accountId;
	private double balance;
	private User owner;
	public Account() {
		super();
	}
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	 
}
