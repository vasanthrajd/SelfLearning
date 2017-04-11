package com.resthibernate.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import com.resthibernate.model.Country;

public class CountryService {
	private static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public CountryService(){
		
	}
	
	public static boolean addCountry(Country country){
		
		System.out.println("Country Info"+country.toString());
		if(!checkCountry(country)){
			Country localCountry=country;
			localCountry.setId(country.getId());
			localCountry.setCode(country.getCode());
			localCountry.setSupportPaypal(country.isSupportPaypal());			
			Session session=sessionFactory.openSession();			
			session.beginTransaction();			
			session.persist(localCountry);			
			session.getTransaction().commit();		
			session.close();
			return true;
		}
		
		return false;
		
	}
	
	private static boolean checkCountry(Country country){
		boolean flag=false;
		
		String countryId=country.getId();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query=session.createQuery("from Country where id = :countryId");
		query.setString("countryId", countryId);
		if(query.list().size()>0){
			flag=true;
		}
		
		return flag;
	}
	
}
