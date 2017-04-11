/**
 * 
 */
package mainClient;

/**
 * @author EE206105
 *
 */
public class FirstProgram {

	
	/* Case 1
	 *  
	 * Detailed declaration of main method
	 *  
	 * Yes, we can declare the main method in the below format provided
	 * 
	 * final static public strictfp void main (String... args){
			System.out.println("Void Main ");
	}*/
	
	
	/*
	 * Case 2
	 * 
	 * Can we overload main method, 
	 *   Yes we can overload main method by JVM will call only the main method 
	 *   which has String[] args as a parameter 
	 * 
	 *
	
	
	
	
	public static void main(){ // Overloaded method with no parameters
		System.out.println(" main Method");
	}
	public static void main(int[] args){ // Overloaded method with no parameters
		System.out.println(" main Method");
	}
	
	public static void main(String[] args){
		System.out.println(" String  Method");
	}
	*/
	
	
	/* Case 3 Method Hiding 
	 * 
	 */
	
	public static void main ( String[] args){
		 System.out.println(" Parent Class Main Method");
	 }
	
}
/*
 * Inheritance applicable here if we don't declare main method in child it will
 * run the main method in Base Class.
 * 
 * 
 */
class smallChild extends FirstProgram{
	
	/*
	 * If the child class have the same method as parent class with static keyword
	 * then it is a special case, It is not a overriding it is method hiding,
	 * 
	 * Child class have the same prototype as per the parent class. 
	 * 
	 * To check run Child class alone and Parent Class alone
	 */
	
	public static void main ( String[] args){
	System.out.println(" Child Class Main Method");
	}
}