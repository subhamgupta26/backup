package com.tienda.bean;

import java.util.Set;

public class Wishlist {

	private int wishlistId;
	private User wishedBy;
	private Set<Product> list;
	public Wishlist() {
		super();
	}
	public Wishlist(int wishlistId, User wishedBy, Set<Product> list) {
		super();
		this.wishlistId = wishlistId;
		this.wishedBy = wishedBy;
		this.list = list;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public User getWishedBy() {
		return wishedBy;
	}
	public void setWishedBy(User wishedBy) {
		this.wishedBy = wishedBy;
	}
	public Set<Product> getList() {
		return list;
	}
	public void setList(Set<Product> list) {
		this.list = list;
	}
	
	
}
