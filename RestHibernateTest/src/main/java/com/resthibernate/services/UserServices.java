package com.resthibernate.services;

import java.util.Collection;
import java.util.Currency;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.resthibernate.model.Carrier;
import com.resthibernate.model.Country;
import com.resthibernate.model.TimeZone;
import com.resthibernate.model.UserDetails;

public class UserServices {

	private static SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	
	public UserServices(){
		
	}

	public static UserDetails addUser(UserDetails user){
		
		if(checkCountry(user.getCountry().getId())){
			if(checkEmail(user.getEmailId())){
				UserDetails localUser=new UserDetails();
				Session session=sessionFactory.openSession();
				session.beginTransaction();
				
				localUser.setEmailId(user.getEmailId());
				localUser.setFirstName(user.getFirstName());
				localUser.setLastName(user.getLastName());
				
				Criteria countryCriteria=session.createCriteria(Country.class);
				countryCriteria.add(Restrictions.eq("id",user.getCountry().getId()));
				List<Country> countryList=countryCriteria.list();
				
				if(countryList.size()!=0){					
					for(Country tmpCountry:countryList){
						System.out.println(tmpCountry.getId());
						localUser.setCountry(tmpCountry);
						break;
					}
				}
								
				/*com.resthibernate.model.Currency currency=userCountry.getCurrency();
				
				if(currency !=null)
					localUser.getCountry().setCurrency(currency);
				
				Collection<TimeZone> timeZone=userCountry.getTimeZone();
				
				Collection<Carrier> carrier=userCountry.getCarrier();*/
				session.persist(localUser);
				session.getTransaction().commit();
				session.close();
				return localUser;			
			}
		}
		return null;
	}
	
	private static boolean checkCountry(String country){
		Session session=sessionFactory.openSession();
		
		Criteria criteria=session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("id", country));
		
		List<Country> countryList=criteria.list();
		if(countryList.size()>0){
			session.close();
			return true;
		}
		session.close();
		return false;
	}
	
	private static boolean checkEmail(String email){
		Session session=sessionFactory.openSession();		
		Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("emailId", email));
		if(criteria.list().isEmpty()){
			session.close();
			return true;
		}		
		session.close();
		return false;
	}
	
	public static UserDetails getUserDetails(String email){
		return getUserDetailsDB(email);		
	}
	private static UserDetails getUserDetailsDB(String email){
		Session session=sessionFactory.openSession();
		UserDetails user=new UserDetails();
		Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("emailId", email));
		if(criteria.list().isEmpty()){
			session.close();
			return null;
		}else{
			
			user=(UserDetails) criteria.list().get(0);
			System.out.println(user.getEmailId());
		}
		session.close();
		return user;
	}	
	
	public static Country getCountryDetails(String countryId){
		return getCountryDetailsDB(countryId);
	}

	private static Country getCountryDetailsDB(String countryId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Country country=new Country();
		Criteria criteria=session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("id", countryId));
		if(criteria.list().isEmpty()){
			session.close();
			return null;
		}else{
			
			country=(Country) criteria.list().get(0);
			System.out.println(country.getId());
		}
		session.close();
		return country;
	}
	
}
