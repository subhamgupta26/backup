package com.tienda.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="exception-message")
public class ExceptionMessage {

	private String message;

	public ExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public ExceptionMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
