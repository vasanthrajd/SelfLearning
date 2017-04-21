package com.resthibernate.resthibernatetest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.resthibernate.model.Country;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	
	public MyResource(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		System.out.println("Invoked from the My Resource in the Progream");
		//this.sessionFactory=sessionFactory;
	}
	
	public MyResource(){
		
	}
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	Query query=session.createQuery("from Country");
    	
    	List<Country> countryList=query.list();
    	for(Country country:countryList){
    		System.out.println(country.toString());
    	}
    	
    	session.close();
        return "Got it!";
    }
}
