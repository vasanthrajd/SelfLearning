package SpringProject.SpringPractice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*  
 * Interface Implementation for the 
 * 
 * ApplicationContextAware, It is to set the ApplicationContext about the IoC Container
 * 
 * BeanNameAware, : toGetBean info
 * 
 * InitializingBean : for Initializing the Bean Values.
 * 
 * DisposableBean : DisposableBean 
 * 
 * public class Triangle implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
 */

public class Triangle implements Shape{
	
/*	
 * It is for setter injection and constructor injection
 * private String type;
	private int height;
	public int getHeight() {
		return height;
	}
	public Triangle(String type) {
		super();
		this.type = type;
	}
	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}
	public Triangle(int height) {
		super();
		this.height = height;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void draw(){
		System.out.println("Triangle is being drawn and it is of Type \t"+getType() + "\t Height is \t"+getHeight());
	}*/
	
	/* Injecting the Objects	
	 */
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private List<Point> points;
	
	
	private ApplicationContext context;
	
	
	
	public List<Point> getPoints() {
		return points;
	}



	public void setPoints(List<Point> points) {
		this.points = points;
	}



	public Point getPointA() {
		return pointA;
	}



	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}



	public Point getPointB() {
		return pointB;
	}



	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}



	public Point getPointC() {
		return pointC;
	}



	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}



	public void draw(){
		System.out.println("Drawing the Triangle");
		System.out.println("Triangle is being drawn with the co-ordinates at Point A \t"+getPointA().getX()+","+getPointA().getY());
		System.out.println("Triangle is being drawn with the co-ordinates at Point A \t"+getPointB().getX()+","+getPointB().getY());
		System.out.println("Triangle is being drawn with the co-ordinates at Point A \t"+getPointC().getX()+","+getPointC().getY());
		//System.out.println(points);
	}
	/*
	 * Injecting Collections
	 * private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw(){
		for(Point point:points){
			System.out.println("Points List X="+point.getX()+","+point.getY());
		}
	}
*/


/*
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean Name get's created \t"+beanName);
	}


	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
	}*/


	/*
	 * It is a custom Initialization, invocation of this method will happen through SPRING IoC Container.
	 * public void myInit(){
		
		System.out.println("Custom Initialization Bean");
		
	}*/
	
	/*
	 * It is a custom DisposeMethod, which can dispose the method invocation.,
	 * 
	 * public void disposeMethod(){
		System.out.println("Dispose Method");
	}*/
	

	/*public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bean in getting Destryoed");
	}
*/

/*
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("After Properties Set Initializing the Bean");
	}
	*/
}
