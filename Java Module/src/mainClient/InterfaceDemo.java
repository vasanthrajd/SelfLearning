package mainClient;


import mainService.InterfaceService1;
import mainUtility.InterfaceUtility1;

public class InterfaceDemo {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*	 This block will have the functionality where the interfaceFixed 
		 * InterfaceRecurring both implements InterfaceService and we are point out those 
		 * class directly by creating the object for that class.
		 * 
		 *  
		 * InterfaceFixed inF=new InterfaceFixed(10000, 1, 8.25);
			InterfaceRecurring inR=new InterfaceRecurring(1000, 24, 8.25);
			System.out.println(inF.getClass().getName());
			inF.Interest();
			System.out.println(inR.getClass().getName());
			inR.Interest();*/
		
		/* This block will have the fucntionality where we can't create the
		 * object for interfaceFixed and interfaceRecurring directly from the 
		 * main. We make use of utility function to create the object for 
		 * both the classes.
		 */
		
	/*	InterfaceUtility1 utility=new InterfaceUtility1();
		try{
		Object obj1=utility.getObj("fixed", 10000, 2, 8.5);
		Object obj2=utility.getObj("recurring", 1000, 24, 8.5);
		System.out.println(obj1.getClass());
		System.out.println(obj2.getClass());
		
		}
		
		catch (Exception e){
		System.out.println(e.getMessage());	
		}*/
		
		InterfaceService1 uten1=InterfaceUtility1.getObj("fixed");
		uten1.Interest(10000, 2, 8.25);
		InterfaceService1 uten2=InterfaceUtility1.getObj("recurring");
		uten2.Interest(1000, 24, 8.25);
		
		}
		
		
			
	}


