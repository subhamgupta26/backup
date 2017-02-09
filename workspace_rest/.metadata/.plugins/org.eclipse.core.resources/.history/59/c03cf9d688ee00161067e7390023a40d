package com.psl.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="employee")
public class Employee{

	
	private int id;
	private String name;
	private int age;
	
	
	public Employee() {
		

	}
	
	public Employee(String name, int age) {
		super();
		
		this.name = name;
		this.age = age;
		
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		
		this.age = age;
	}

	

	
	

	@Override
	public String toString() {
		return String.format("Employee [id=%s, name=%s, age=%s]", id, name, age);
	}

	public void abc() {
		System.out.println("IN ABC");

	}
	public void pqr() {
		System.out.println("IN pqr");

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
