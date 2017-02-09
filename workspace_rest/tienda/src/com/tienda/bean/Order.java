package com.tienda.bean;

import java.util.Date;
import java.util.Set;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.tienda.util.OrderStatus;


@XmlRootElement(name="order")
public class Order {

	private int OrderId;
	private String number;
	private Date orderedOn;
	private User OrderedBy;
	private OrderStatus status;
	private Set<Product> cart;
	
	
	
	public Order() {
		super();
	}
	public Order(int orderId, String number, Date orderedOn, User orderedBy,
			OrderStatus status, Set<Product> cart) {
		super();
		OrderId = orderId;
		this.number = number;
		this.orderedOn = orderedOn;
		OrderedBy = orderedBy;
		this.status = status;
		this.cart = cart;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getOrderedOn() {
		return orderedOn;
	}
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}
	public User getOrderedBy() {
		return OrderedBy;
	}
	public void setOrderedBy(User orderedBy) {
		OrderedBy = orderedBy;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	@XmlElementRef
	@XmlElementWrapper(name="cart")
	public Set<Product> getCart() {
		return cart;
	}
	public void setCart(Set<Product> cart) {
		this.cart = cart;
	}
	
	
	
	
}
