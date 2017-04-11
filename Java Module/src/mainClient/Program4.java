package mainClient;

// Immutable Custom Class 

/* Rule
1) Don't set any setter method
2) Make the instance fields as private and as well as Private
3) Don't allow a chance for the class to be subclass so declare the class with final keyword
4) Don't give reference to any external class.
*/

// class Program4 extends Immutable : Can't inherit the class which is declared as a Final.




final class Immutable1{

final private int red;
final private int green;
final private int blue;
final private String name;

// Business Logic to check whether the passed arguments are bound to limits or not.

public void check(int red, int green, int blue){
	if(red < 0 || red >255 || green < 0 || green > 255 || blue < 0 || blue > 255 ){
	throw new IllegalArgumentException();
} 
}

public Immutable1(int red, int green, int blue, String name){

check(red,green,blue);	// For the chekcing the business logic, it is a internal function of the class

this.red=red;
this.green=green;
this.blue=blue;
this.name=name;

}

public int getRGB(){
	return ( (red<<16) | (green << 8) | blue );
}

public String getName(){
	return name;
}

public Immutable1 invert(){
	// Returns the Object
	return new Immutable1(255-red, 255-green, 255-blue,"Inverse of "+name);		
}
}



class Program4
{
	public static void main(String[] args){
		Immutable1 i1=new Immutable1(125, 125, 125, "Torquise");
		System.out.println(i1.getName());
	//	System.out.println(i1.invert());
		Immutable1 i2=i1.invert();
		System.out.println(i2.getName());
	}

}