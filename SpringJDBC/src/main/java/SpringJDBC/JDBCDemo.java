package SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringJDBC.DAO.Daoimpl;
import SpringJDBC.DAO.HibernateDaoImpl;

import SpringJDBC.DAO.SimpleDAOImpl;
import SpringJDBC.Model.Circle;

public class JDBCDemo {
	public static void main(String[] args){
		
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
		Daoimpl dao=context.getBean("daoimpl", Daoimpl.class);
		
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		System.out.println("Count of Circle :"+dao.getCircleCount());
		System.out.println("Circle Name :"+dao.getCircleName(1));
		System.out.println("Circle Name for the Circle Id :"+dao.getCircleforId(1).getName());
		
		/*	Inserts new Circle : Insert Query 
	 	* dao.insertCircle(new Circle(4,"Fourth Circle Inserted"));
	 	*/	
		
		/* Create table
		 * dao.createTriangleTable();
		*/
		//dao.insertCircleNamed(new Circle(5,"Fifth Circle Inserted"));
		System.out.println("Size of total Circles\t"+dao.getAllCircles().size());
		SimpleDAOImpl sDao=context.getBean("simpleDAOImpl", SimpleDAOImpl.class);
		
		System.out.println("Simple DAO Result :"+sDao.getCircleCount());
		
		HibernateDaoImpl hDao=context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println("Hibernate DAO Result :"+hDao.getCircleCount());
	}
}
