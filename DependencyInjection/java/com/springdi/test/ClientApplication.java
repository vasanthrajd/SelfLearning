package com.springdi.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdi.configuration.DIConfiguration;
import com.springdi.consumer.MyAppAnnotate;

public class ClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 
		 * AnnotationConfigApplicationContext is the implementation of AbstractApplicationContext abstract class 
		 * and it’s used for autowiring the services to components when annotations are used. 
		 * AnnotationConfigApplicationContext constructor takes Class as argument that will be used to get 
		 * the bean implementation to inject in component classes.
		 * 
		 * getBean(Class) method returns the Component object and uses the configuration for autowiring the objects. 
		 * 
		 */
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DIConfiguration.class);
		MyAppAnnotate app=context.getBean(MyAppAnnotate.class);
		app.processMessage("dvasanth@sasken.com", "Annotation Spring Dependency Injection");
		
		context.close();
	}

}
