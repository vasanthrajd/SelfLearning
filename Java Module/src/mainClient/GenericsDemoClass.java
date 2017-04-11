package mainClient;

public class GenericsDemoClass {

	public static void main(String[] args){
		CountryDemo countryDemo=new CountryDemo();
		countryDemo.setCapital("New Delhi");
		countryDemo.setName("India");
		GenericsDemoClass genericsDemoClass=new GenericsDemoClass();
		genericsDemoClass.showClassValue(countryDemo);
	}
	
	public boolean showClassValue(Object t){
		
		return true;
	}
}
