package SpringProject.SpringPractice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;


@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher publisher;
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}
	/* @Required
	 * It will validate the Bean Container and will throw up the result of validation, if there isn't any new 
	 * it will throw up the error.
	 * 
	 * It will allow us to define on top of Setter Method.
	 */
	
	/* It will help to autowire the setter functionality to the spring container, where we don't need to mention anything for 
	 * mapping of values. 
	 * @Autowired
	   @Qualifier("circleRelated")
	*/
	
	/*
	 * @Resource(name="point2"): It will look for the bean name mentioned,
	 * if not it will look for the bean with the same name of property name.
	 * 
	 */
	
	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}


	public void draw() {
		// TODO Auto-generated method stub
			System.out.println(this.messageSource.getMessage("drawing.circle",null,"Default Message:Drawing Method", null));
			
			System.out.println("Center Point is : "+center.getX()+", "+center.getY());
			
			/*
			 * The value for the center object where dynamically passed from this class, but it carries the static message from the
			 * properties. 
			 * 
			 * The properties file must implement the structure with parameter named format.
			 * 
			 * Ex: drawing.point=Circle Point is:({0},{1})
			 */
			
			System.out.println(this.messageSource.getMessage("drawing.point",new Object[]{center.getX(),center.getY()},"Default Message:Default Point", null));
			
			
			System.out.println(this.messageSource.getMessage("greeting", null, "Default Message:No Properties Key Value Greeting Found", null));
		
			/*
			 * It is a Custom Publish Event, we can invoke at any point in our Application 
			 * 
			 * Publish the Event. 
			 * In order to publish a event, Spring have applciationEventPublisher
			 */
			DrawEvent drawEvent=new DrawEvent(this);
			publisher.publishEvent(drawEvent);
			
	}

	@PostConstruct
	public void initializeCircle(){
		System.out.println("Init of Circle");
	}
	@PreDestroy
	public void destroyCircle(){
		System.out.println("Destroy of Circle");
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		
		// * Spring will provide the applicationContext, which produces the event that we registred.
		 
		System.out.println("Invocked ~~~~~~~~~~~~~~~~~~~~~~");
		this.publisher=publisher;
		System.out.println("Invocked ~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
}
