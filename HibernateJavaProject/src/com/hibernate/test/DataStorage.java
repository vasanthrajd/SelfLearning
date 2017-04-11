package com.hibernate.test;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.web.FourWheeler;
import com.hibernate.web.TwoWheeler;
import com.hibernate.web.User;
import com.hibernate.web.UserDetails;
import com.hibernate.web.Vehicle;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataStorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");	
		
		SessionFactory factory=cfg.buildSessionFactory();		
		Session session=factory.openSession();		
		Transaction transaction=session.beginTransaction();
		
		Employee e1=new Employee();
		e1.setId(1001);
		e1.setFirstName("Vasanthraj");
		e1.setLastName("Devaraju");

		session.persist(e1);
		transaction.commit();
		session.close();
		System.out.println("Data Saved Successfully");*/
		/*
		UserDetails userDetails=new UserDetails();
		userDetails.setUserId(104);
		userDetails.setUserName("vdevaraj");
		userDetails.setJoinedDate(new Date());
		userDetails.setDescription("Description about the user Details");
		userDetails.setAddress("Taramani, Chennai");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		session2.save(userDetails);
		session2.getTransaction().commit();
		session2.close();
		
		userDetails=null;
		session2=sessionFactory.openSession();
		session2.beginTransaction();
		userDetails=session2.get(UserDetails.class, 104);
		System.out.println("User Details Retrived :"+userDetails.getUserName());*/
		
		/*LoginPrimary loginPrimary=new LoginPrimary();
		LoginPrimary loginPrimary1=new LoginPrimary();
		loginPrimary.setLoginId("abc@one.com");
		loginPrimary1.setLoginId("xyz@one.com");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(loginPrimary);
		session.save(loginPrimary1);
		session.getTransaction().commit();
		session.close();
		*/
		/*
		User user=new User();
		user.setPanCard(101);
		user.setRationCard(101);
		userDetails.setUser(user);
		User user1=new User();
		user1.setPanCard(102);
		user1.setRationCard(102);
		userDetails1.setUserId(101);
		userDetails1.setUser(user1);*/
		
		/*
		 * Transient Object
		 */
	/*	UserDetails userDetails=new UserDetails();
		userDetails.setUserName("vdevaraj");
	*/	
		
		UserDetails userDetails=new UserDetails();
		
		userDetails.setUserName("User :1%");

		Example example=Example.create(userDetails);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		/*Criteria criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 2),Restrictions.between("userId", 7,9)));
		*/	
	
//		Criteria criteria=session.createCriteria(UserDetails.class);
//		//criteria.setProjection(Projections.max("userId"));
//		criteria.add(example);		
//		//UserDetails userDetails2=(UserDetails)criteria.list().get(0);
//		
//		//System.out.println(userDetails2.getUserName());
//		List<UserDetails> users=(List<UserDetails>) criteria.list();
//		
//		session.getTransaction().commit();
//		session.close();
//		for(UserDetails user:users){
//			System.out.println(user.getUserId()+"\t"+user.getUserName());
//		}
		
		//UserDetails userDetails2=(UserDetails)session.get(UserDetails.class, 1);
		Query query=session.createQuery("from UserDetails ");
		query.setCacheable(true);
		List users=query.list();
		
		session.close();
		
		Session session1=sessionFactory.openSession();
		session1.beginTransaction();
		
		//UserDetails userDetails3=(UserDetails)session1.get(UserDetails.class, 1);
		
		Query query2=session1.createQuery("from UserDetails ");
		query2.setCacheable(true);
		List users2=query2.list();
		
		
		
		session1.close();
		
		System.exit(0);
		
		
		//Query query=session.createQuery("from UserDetails");
		/*Query query=session.getNamedQuery("user_details.byName");
		query.setString(0, "updated UserName");
		*/
		/*
		 * from UserDetails, is an Class Name not the Table.
		 */
	//	Query query=session.createQuery("select new Map(userId,userName) from user_details");
		/*
		 * Query Injection 
		 */
		/*String userId="5";
		String userName="User :9";		
		
		Query query=session.createQuery("from user_details where userId > :userId  and userName = :userName");
		
		query.setInteger("userId", Integer.parseInt(userId));
		query.setString("userName", userName);*/
		
		
		/*query.setInteger(0, Integer.parseInt(userId));
		query.setString(1, userName);
		*/
		//List<UserDetails> users=(List<UserDetails>)query.list();
		/*session.getTransaction().commit();
		session.close();
		for(UserDetails user:users){
			System.out.println(user.getUserId()+"\t"+user.getUserName());
		}
		System.exit(0);
		*//*for(List<String> user:users)
			//System.out.println(user.getUserId()+"\t"+user.getUserName());
			for(String result:user){
				System.out.println(result);
			}
			
		}*/
		
		
		/*
		 * Insert the new Record in the DB Table.
		 */
		/*
		 * Persistent Object to the Detached then coming back to the Persistent
		 * 
		 * hibernate.annonation(selectBeforeUpdate=true)
		 *//*
		userDetails=session.get(UserDetails.class, 11);
		session.save(userDetails);
		
		userDetails.setUserName("Updated in the Session Persistent");
		userDetails.setUserName("Second Updated in the Session Persistent");
		
		session.getTransaction().commit();
		session.close();
	*/
	/*	userDetails.setUserName("Detached Object using Update");
		
		System.out.println(userDetails.getUserName());
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(userDetails);
		session.getTransaction().commit();
		System.exit(0);
	*/	
	/*	Insert 10 User Records
	 * 	for(int i=0;i<10;i++){
			UserDetails userDetails=new UserDetails();
			userDetails.setUserName("User :"+i);
			session.save(userDetails);
		}
	*/	
		
		/*
		 * Read the Data from the Table.
		UserDetails user=session.get(UserDetails.class, 6);
		System.out.println("Retrieved the User Details info Name :"+user.getUserName() );
		*/
		/*
		 * Updating the UserDetails Row.
		 * 
		UserDetails user=session.get(UserDetails.class, 5);
		
		user.setUserName("updated UserName");
		session.update(user);*/
		/*
		 * Deleted the Row in the Table.
		session.delete(user);
		*/
	
	/*	Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("VehicleNameAdded");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Ducati");
		bike.setStreeingHandle("Handle Bar");
		
		FourWheeler car=new FourWheeler();
		car.setVehicleName("PORSCHE");
		car.setStreeingWheel("Streeing Bar");
		
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		System.exit(0);
	*/	
		
		/*UserDetails userDetails=new UserDetails();
		userDetails.setUserName("vdevaraj");
			
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Mercedes");
		//vehicle.getUserList().add(userDetails);
		
		 * For Many to One Mapping
		vehicle.setUser(userDetails);
		
		userDetails.getVehicle().add(vehicle);
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleName("MercedesSClass");
		//vehicle1.getUserList().add(userDetails);
		
		 * For Many to One Mapping.
		vehicle1.setUser(userDetails);
		
		userDetails.getVehicle().add(vehicle1);
		
		session.persist(userDetails);
		session.save(vehicle);
		session.save(vehicle1);
		
		session.getTransaction().commit();
		session.close();
		
		session=sessionFactory.openSession();
		userDetails=null;
		session.getTransaction();
		
		userDetails=session.get(UserDetails.class, 1);
		session.close();
		System.out.println(userDetails.getUserId());
		System.out.println(userDetails.getUserName());
		
		
		System.exit(0);
*/		
	}

}
