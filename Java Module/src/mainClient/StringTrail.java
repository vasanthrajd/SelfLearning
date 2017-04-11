package mainClient;

public class StringTrail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Every String Object should be enclosed in the doubel quotes
		 * 
		 */
		String s1=new String("String Concatenation");
		//String s2="StringDemo";
		s1.concat("String");
		System.out.println(s1);
		
		
		StringBuffer s2=new StringBuffer("String Concatenation");
		s2.append("String");
		System.out.println(s2);
		
		
		
	}

}
