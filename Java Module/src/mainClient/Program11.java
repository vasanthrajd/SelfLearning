package mainClient;

public class Program11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcDEFghiJKL";
			
//	    for(int i=0;i<s.length();i++){
//			 
//		    char l = s.charAt(i);
//			if(l>64 && l<91){
//				
//				l=(char)((l+32));
//				System.out.print(l);
//				}
//			else if(l>96 && l<123){
//				
//				l=(char)(l-32);
//				System.out.print(l);
//			}
		for(int i=0;i<s.length();i++){
				 
				 char l = s.charAt(i);
			     if(l>=97 && l<=122){
			    	 	l=(char)(l-32);
			    	    System.out.print(l);
				  }
			     else{
				    System.out.print(l);
				}
		}
		
			   
		 }
	}
