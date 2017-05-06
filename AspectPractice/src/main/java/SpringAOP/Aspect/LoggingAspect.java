package SpringAOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import SpringAOP.Model.Circle;


public class LoggingAspect {
	/*
	 * Qualified with Proper Package Path Name
	@Before("execution(public String SpringAOP.Model.Circle.getName())")
	*/
	/*@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinpoint){
		
		System.out.println(joinpoint.toString());
	*/
	/*
	 *  With the below line, you can get the object which initiates this call. 
	 * 	Circle circle=(Circle)joinpoint.getTarget();
		circle.setName("FROM Loggin Aspect");
		System.out.println(circle.getName());
	*
		System.out.println("Advice Run : GET Method is Called");
	*/
	/*@Before("allGetters()")
	public void secondAdvice(){
		System.out.println("Second Advice Executed.");
	}
	*/
/*	@Pointcut("execution(* get*())")
	public void allGetters(){
	}*/
	
	/* For all the methods present in Circle Class*/
	/*@Pointcut("within(SpringAOP.Model.Circle)")	
	public void allCircleMethods(){}
	*/
	/*For all the methods present in Root Packages Class
	@Pointcut("within(SpringAOP.Model.*)")	
	public void allCirclePackageMethods(){}
	*/
	
	/*For all the methods present in Root Packages and Sub Packages Class
	@Pointcut("within(SpringAOP.Model..*)")	
	public void allCirclePackageSubMethods(){}
	*/
	
	
	/* It will execute on the occasion defined in the args list.
	 * @Pointcut(args())
	*/
	
	/*@Before("args(String)")
	public void stringArgumentMethod(){
		System.out.println("A method works when String Argument is passed.");
	}*/
	
	/*@Before("args(name)")
	public void stringArgumentMethod(String name){
		System.out.println("A method works when String Argument is passed. > Value Accessed in Advice >>"+name);
	}
	
	
	@After("args(name)")
	public void stringArgumentMethodAfter(String name){
		System.out.println("A method works when String Argument is passed. > Value Accessed in Advice After Annotation >>"+name);
	}
	@AfterReturning(pointcut="args(name)",returning="returnedString")
	public void stringArgumentMethodAfterReturning(String name, String returnedString){
		System.out.println("A methodReturning works when String Argument is passed. > Value Accessed in Advice After Annotation >>"+name+"\tValue accessed from Return Type"+returnedString);
	}
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionMsg(String name, RuntimeException ex){
		System.out.println("Throwing the Exception Result >>>>"+name+"\t The Exception throwng is \t"+ex);
	}
	*/
	//@Around("@annotation(SpringAOP.Aspect.Loggable)")
//	@Around("allGetters()")
	public void myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		try {
			
			System.out.println("Before Advice Method");
			/*
			 * Above is Before Method.
			 */
			// Below line is a point which will trigger the target method get's executed. 
			proceedingJoinPoint.proceed();
			
			/*
			 * Below is After Method has successfully Executed
			 */
			
			
			System.out.println("After Returning Advice Method");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
			e.printStackTrace();
			
		}
		System.out.println("After Finally");
	}
	
	public void loggingAdvice(){
		System.out.println("Logging from the Advice");
	}
}
