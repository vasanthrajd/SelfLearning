package com.springdi.consumer;

import com.springdi.services.MessageServices;

/*
 * For XML based configuration, we can use implement either constructor-based spring dependency injection or 
 * method-based spring dependency injection. 
 * Note that method-based and setter-based injection approaches are same
 * 
 */

public class MyAppXml {
	
	private MessageServices service;
	
	/*
	 * Constructor Based Dependency Injection
	 * 
	 * public MyAppXml(MessageServices services){
		this.services=services;
	   }
	 */
	public MessageServices getService() {
		return service;
	}
	/*
	 * Setter Based Dependency Injection.
	 */
	public void setService(MessageServices service) {
		this.service = service;
	}
	public boolean processMessage(String msg, String rec) {
		// some magic like validation, logging etc
		return this.service.sendMessage(msg, rec);
	}
	
	
}
