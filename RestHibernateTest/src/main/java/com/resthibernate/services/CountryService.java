package com.resthibernate.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import com.resthibernate.model.Carrier;
import com.resthibernate.model.Country;
import com.resthibernate.model.Currency;
import com.resthibernate.model.TimeZone;

public class CountryService {
	private static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public CountryService(){
		
	}

	public static boolean addCountry(Country country){
		
			
			if(!checkCountry(country)){
				Country localCountry=country;
				localCountry.setId(country.getId());
				localCountry.setCode(country.getCode());
				localCountry.setSupportPaypal(country.isSupportPaypal());	
				
				Currency localCurrency=country.getCurrency();
			
				if(localCurrency!=null){
					localCurrency.setName(country.getCurrency().getName());
					
					localCurrency.setShortName(country.getCurrency().getShortName());
			
					localCurrency.setSymbol(country.getCurrency().getSymbol());
			
					localCurrency.setDefault(country.getCurrency().isDefault());
			
					
					
					localCountry.setCurrency(localCurrency);
				
				}			
				Set<TimeZone> localTimeZone= (Set<TimeZone>) country.getTimeZone();
				
				if(localTimeZone!=null){
					for(TimeZone tmpTimeZone:localTimeZone){
						tmpTimeZone.setCountry(localCountry);
						localCountry.getTimeZone().add(tmpTimeZone);
					}
				}
				
				Set<Carrier> localCarrier=country.getCarrier();
				if(localCarrier!=null){
					for(Carrier tmpCarrier:localCarrier){
						tmpCarrier.getCountry().add(localCountry);
						localCountry.getCarrier().add(tmpCarrier);
					}
				}
				
				
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
