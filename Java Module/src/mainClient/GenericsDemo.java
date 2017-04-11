package mainClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {
	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 		
		ArrayList al=new ArrayList();
		al.add("one");
		al.add(2);
		System.out.println(al.get(1));
		System.out.println(al);
		
		/*
		 * *
		 * Below statement will report error, Cannot convert from Object to int, it requires
		 * type casting at the time of assigning the values.
		 * int i=al.get(0); 
				String str=al.get(0);
		*/
		
		
		
		/*
		 * The below declaration will prevent the a1 object to have String objects
		 * only for storing the data. 
		 						
		ArrayList<String> a1=new ArrayList<>();
		a1.add("one");
		a1.add("two");
		
		 * The below statement will report error since a1 A.L expects String objects 
		 * not the Integer.
		 * a1.add(1);
		 */
		
		/*
		 * While retrieving the elements from the A.L we don't need to do any Type Casting. 
		 */
	 
		/*
		 * Through Generics we are associating type parameter to classes. such type of
		 * parameter classes are called Generic Classes. 
		 */
		/*
		 * We can pass anytype of objects, the generics class will accept those as
		 * a object type and will give the results according to its type.
		 * Below we have set two pararmeters one as String and another one as a
		 * primitive type which will be converted to Wrapper Class Integer.
		 */
		//Generics g1=new Generics("String" , 1234);
		//Generics g1=new Generics(1234 , 1234);
	//	System.out.println(g1);
		/*
		 * The below two setOb will assign the new data type and the same will be 
		 * returned by the super class.
		 */
		//g1.setOb(12.34);
	    //g1.setOb1(" Name ");
	//	System.out.println(g1);
	/*	dummy1 d1=new dummy1("d1 is Object of Dummy 2 Class");
		dummy2 d2=new dummy2("d2 is Object of Dummy 2 Class");
		g1.setOb(new dummy1("Class name"));
		g1.setOb1(d2);
		System.out.println(g1);
		*/
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		printList(li);
		printList(ls);
	}
}
/*
 * Generic Class: 
 * 	When defining the Generic class, we need to mention what type parameter
 *  we will be using in the class, it helps the class associate to which ever object 
 *  that is being passed to the class and allocate memory according to it.
 *
 * 1. It is a Unbounded Type:
 * 
 * Adv.
 * 	  i) We can assign any type of object, including user defined objects
 * 
 * 2. Bounded type:
 *
 * 	It can be done by using extends keyword not by implementing class or by super class
 * 
 * 	Adv.
 * 	  i) We can restrict the type parameter to a particular type.
 * 	 ii) We can use interface as a extended type parameter, it implies that type
 *  	parameter is of type of any type of class which has done the implementation
 *      of the interface.
 * 
 * Even though if we use Interface for the bounded type we should use extends keyword
 * but the format should be like class & interface
 * 
 *   ii) We can't extend more than one class.
 *
 * class Generics<T extends Number,E>
 * 
 * by declaring as in above type, Generic class expects T Object to be any class which
 * extends Number Class
 * 
 *  So, it get error if we call the Generics Constructor from the Main 
 *  
 */
class Generics<T,E> {
	T ob;
	E ob1;
	public Generics(T ob, E ob1) {
		super();
		this.ob = ob;
		this.ob1 = ob1;
	}
	public T getOb() {
		return ob;
	}
	public void setOb(T ob) {
		this.ob = ob;
	}
	public E getOb1() {
		return ob1;
	}
	public void setOb1(E ob1) {
		this.ob1 = ob1;
	}
	@Override
	public String toString() {
		return "Generics [ob is a object of =" + ob.getClass().getName() +" "+ ob + ", ob1 is object of =" + ob1.getClass().getName()+ " "+ ob1 + "]";
		}
}
/*
 * Created two dummy class for understanding about how does generic class works.
 */
class dummy1 extends Number{
	String name;

	public dummy1(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "dummy1 [name=" + name + "]";
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
		
}
class dummy2{
	String name;

	public dummy2(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "dummy2 [name=" + name + "]";
	}
		
}