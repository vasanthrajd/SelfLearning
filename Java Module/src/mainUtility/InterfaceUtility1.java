package mainUtility;

import mainService.InterfaceFixed;
import mainService.InterfaceRecurring;
import mainService.InterfaceService1;

public class InterfaceUtility1 {
	
	
	private static InterfaceService1 inServ;
	
	public static InterfaceService1 getObj(String name ){
		 
			if(name.contains("fixed")){
				inServ=new InterfaceFixed();
			}
			if(name.contains("recurring")){
				
				inServ=new InterfaceRecurring();
			}
			return inServ;
	}
	
		
}
