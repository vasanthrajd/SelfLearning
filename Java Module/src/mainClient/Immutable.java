package mainClient;



final class Immutable{

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

public Immutable(int red, int green, int blue, String name){

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

public Immutable invert(){
	
	return new Immutable(255-red, 255-green, 255-blue,"Inverse of "+name);
}
}