package SpringAOP.AspectPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import SpringAOP.Service.FactoryService;
import SpringAOP.Service.ShapeService;

public class AOPMain {
	public static void main(String[] args){
		/*	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
			ShapeService service=context.getBean("shapeService",ShapeService.class);
		*/	/*System.out.println("1>>>"+service.getCircle().getName());
			System.out.println("2>>>"+service.getCircle().showName());*/
		
		//	System.out.println("3>>>"+service.getCircle().getName());
			
			FactoryService factoryService=new FactoryService();
			ShapeService service=(ShapeService)factoryService.getBean("shapeService");
			service.getCircle();
			
	}
}
