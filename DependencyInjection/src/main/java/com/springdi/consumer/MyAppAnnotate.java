package com.springdi.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springdi.services.MessageServices;

/*
 * Annotation used :
 * @Component: Annotation is added to the class, so that when Spring framework will scan for the components, 
 * 			   this class will be treated as component. @Component annotation can be applied only to the
 * 			   class and it's retention policy is Runtime.
 * 
 * @AutoWired: annotation is used to let Spring know that auto wiring is required. This can be applied to 
 * 			   field, constructor and methods. This annotation allows us to implement constructor-based, 
 * 			   field-based or method-based dependency injection in our components.
 * 
 */

@Component
public class MyAppAnnotate {

	/*
	 * @Autowired : It is Field Based Dependency Injection.
	 */	
	private MessageServices service;
	/*
	 * @Autowired : It is Constructor Based Dependency Injection.
	public MyAppAnnotate(MessageServices service) {
		super();
		this.service = service;
	}*/
	public MessageServices getService() {
		return service;
	}
	@Autowired
	public void setService(MessageServices service) {
		this.service = service;
	}	
	public boolean processMessage(String recipent, String message){
		return this.service.sendMessage(message, recipent);
	}	
}
