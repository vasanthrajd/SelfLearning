package com.resthibernate;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.resthibernate.resources.CustomResource;
import com.resthibernate.resthibernatetest.MyResource;

/*
 * This Class will be initializing the Resource Created under the resource directory, which is responsible for
 * REST API Creation
 */
public class AccessApplication extends Application{

	private Set<Object> singletons =new HashSet<Object>();
	private Set<Class<?>> classes= new HashSet<Class<?>>();
	//private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public AccessApplication(){
		addResource(new CustomResource());
		//addResource(new MyResource(sessionFactory));
		addResource(new MyResource());
	}
	
	private void addResource(final Object object){
		this.singletons.add(object);
		this.classes.add(object.getClass());
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

	public void setSingletons(Set<Object> singletons) {
		this.singletons = singletons;
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class<?>> classes) {
		this.classes = classes;
	}
		
}
