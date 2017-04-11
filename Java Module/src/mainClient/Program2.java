package mainClient;
// Public is a access specifier, by defining a class as a public then on compiling JVM expects file name and class name should be same.



public class Program2{

static{
System.out.println(" In Program 2 Static Block");
}

Program2(){
System.out.println("No Argument Constructor");
}

 public static synchronized strictfp  void main  (String... args) throws Exception{
 int i=0,len=args.length;

// Undertstanding the usage of Command Line Arguments.

for(;i<args.length;i++){
	System.out.println("Command Line Arguments="+i+" "+args[i]);
}


//System.out.println("X value is = "+10/0); Both are int/int so it will return Arithemetic Exception Divide By Zero

//System.out.println("X1 value is = "+ (-10)/0.0); int/double it will return a special type which is called Positive Infinity and Negative Infinity.

//System.out.println("X2 value is = "+0/0); The result is undefined, so it will also report Arithemetic Exception Divide by Zero.

//System.out.println("X value is = "+0.0/0); It will return a special type double/int. So it will return NaN. Not a Number

// Equality operator cross checking. It will help to compare the two objects to check whether both the objects point to same location or not.

/*
Thread d1=new Thread();
Thread t2=new Thread();
Thread t3=d1;
System.out.println(d1==t2);
System.out.println(d1==t3);
*/

/*
Equality Operator
Thread d1=new Thread();
Object o2=new Object();
String str=new String("String");
System.out.println(d1==o2);
System.out.println(o2==str);*/
//System.out.println(str==d1); incomparable operator types for string and thread. Only the comparable object types should be used here.
// Understanding of Assignment of String Object to Another Object.

/*
instanceof operator 

Thread d1=new Thread();
System.out.println(d1 instanceof Thread);
System.out.println(d1 instanceof Object);
System.out.println(d1 instanceof Runnable);*/

// System.out.println((10 < 20) < 30); It will report the compiler error stating that, boolean can't be compared with int

String a="Java";
int b=10, c=20, d=30;
System.out.println(a+b+c+d);
System.out.println(b+c+d+a);
System.out.println(b+c+a+d);
System.out.println(b+a+c+d);



// Things to note, if we assign arguments less than the accutal size of the array, then it will be assigned and it will be overwritten

 String[] argh={"hi", "bye","rock"};
 if(args.length>0)
	argh=args;
for(String s:argh){
 System.out.println("String array "+s);
 }
// It is simple object creation for this class on how to create the object and how new keyword works. 

//	Program2 p2=new Program2();

// It is a line to understand how does newInstance() operator, works. newInstance() will create the object at run time when we don't know class name and how to create the object for that unknown class name. It works only in run time. This example will create the object from the command line arguments. Since we don't know what time of class name we are making use of Object as generic class name.

// Whenever we try to create a object at run time we need to make sure we use checked exception by throwing the exception.

/*
Object o=Class.forName(args[0]).newInstance();

System.out.println("New dynamic Object created for the command line argument which is a class "+o.getClass().getName());
*/

// instanceOf and isInstance().

Program2 p1=new Program2();
child1 c1=new child1();
Thread t1=new Thread();
String s1=new String();

System.out.println(p1 instanceof Program2); 

System.out.println(c1 instanceof child1);

//System.out.println( t1 instanceof Thread);
System.out.println(Class.forName(args[0]).isInstance(t1));
System.out.println(Class.forName(args[1]).isInstance(s1));

 }


// Overloading of Main Method is possible. There won't be any compile time error or run time error
public static synchronized strictfp  void main  (Integer... args){
 }

}



//It is a child class and it can also have the main method and it can overwrite the super class, if this class doesn't overwrite the super class it will execute the super class main method. Irrespective of being where the static block is placed, it will run the static block first
class child1 {
	static{
	System.out.println("Static Method of Child");
	}
/* 	public static void main(String...args){
		System.out.println("Inheritance from the Super");
	} */

}