package SpringProject.SpringPractice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * It is Raw way to create the object for the class
		Triangle triangle=new Triangle();
		*/
		
		/* 1. Bean Factory Object Creation.
		 * Spring and BeanFactory way to create a object for the class
		 * spring.xml, will act as a blue print to get object for the class and along with 
		 * all the required parameters for the class to be included in the same configuration file. 
		 * 
		 * Here I have specified the path to locate the file, using FileSystemResource.
		 * 
		 * BeanFactory beanFactory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		 * Triangle triangle=(Triangle)beanFactory.getBean("triangle");
		 * triangle.draw();
		 */
		
		/*
		 * This is another way of positioning the file which is capabale of instantiating the class.
		 */
		/*
		 * ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		*/
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
/*		Triangle triangle=(Triangle)context.getBean("triangle1");
		triangle.draw();
		
		Circle circle=(Circle)context.getBean("circle");
		circle.draw();
*/		
		Shape shape=(Circle)context.getBean("circle");
		shape.draw();
		
		//System.out.println(context.getMessage("greeting", null, "Default Message:No Properties Key Value Greeting Found", null));
		
		
	}

}
