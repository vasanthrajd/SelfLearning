package mainClient;

// Classes and Objects

import java.util.Scanner;

class Program3 extends Child2{

// if we access the instance variable within the base class, we can make use of private variable and also can change the private value to our own value.

/*private int a;

Program3(){
System.out.println("Base Class Constructor");
}

public void change(int x){
	a=x;
	System.out.println("Private Value changed="+a);
}
*/
//@overwrite We need to implement Cloneable Interface and we need to overwrite the clone function of the Object Class
/*protected Object clone() throws CloneNotSupportedException {
 	
	return (Program3) super.clone();
}*/

/*public static void main(String[] args) throws Exception 	
{

// Different ways we can create the objects	
// #1

//	Program3 p3=new Program3();

//#2 Class.forName("className").newInstance();
//	Object o=(type cast for which ClassName)Class.forName("ClassName").newInstance();

//	Object o=(Program3)Class.forName("Program3").newInstance();

// ClassLoader.loadClass() and can specify a different ClassLoader it's not initialized until it's used for first time.
//#3

//	 Need to check how it works

//	Program3 p4=(Program3)p3.clone(); It reports Clone Not Supported Exception at run time, to overcome this programmer needs to implement Cloneable Interface and we need to override the clone() method to make use of clone()
	
//	Program3 p4=(Program3)p3.clone();

//#4 newInstance();
	
//	Object o1=Program3.class.getClassLoader().loadClass("Program3").newInstance();
	
Program3 p1=new Program3();
System.out.println(p1.a);
}*/

public static void main(String[] args){

	Child2 p1=new Child2();
//	System.out.println("Private Variable of Program3="+p1.a);
	int a;
	System.out.println("Enter the value to modify the instance Variable");
	Scanner sc=new Scanner(System.in);
	a=sc.nextInt();
//	p1.a=a;
	p1.change(a);

// in the below example even though we declare the instance variable as private, we can able to change the private variable by setter method, with which we can pass the value to the class and let the class logic to decide the set the value. This is encapsulation. 
//	System.out.println("Assigning the scanned value ="+ p1.a);
}
	
}

class Child2{

private int a=10;		// Will report CE; if we specify private access modifier for the variable declared in child

// Constructor for checking how does it work

Child2(){  // By declaring the constructor private we can prevent the class to be instantiated, use of this is for singleton, factory method, static method utility class, constant only class


System.out.println("Child Constructor");
}

public void change(int x){
	a=x;
	System.out.println("Private Value changed="+a);
}

}