package mainClient;
// Constructor understanding about this() and super().

class cons{

String name;

cons(){
System.out.println("Super Class No Argument Constructor");

//System.out.println("No Argument Constructor="+name);
// On creating the object, no argument constructor will get first Preference, so by default the instance variable "name" will have null.

	}


cons(String value){
	this();		// Will call constructor within the same class. 
	name=value;
	System.out.println(" Super Class Argument Constructor="+name);	
}
	
}

class decons extends cons{

	private	String name;

	decons(){	
			super("child no arg super const");
			System.out.println("Accessing Super Class="+super.name);
	}
	decons(String name){	
		this();
		//super("Child Class with 1 Arg Cons="+name);
		name=name;
		System.out.println("Child Class One Argument Const="+name);
	}
	
}

class Program6{
public static void main(String[] args)
{
	//	cons c1=new cons("Constructor Program");	// New Object Creation
	decons d1=new decons("Decons");
}

}