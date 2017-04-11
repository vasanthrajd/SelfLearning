package mainClient;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class CloneDemo {

	/**
	  @param args
	 * @throws CloneNotSupportedException 
	  */
	 	public static void main(String[] args) throws CloneNotSupportedException {
//		 TODO Auto-generated method stub
	/*	System.out.println("Enter your choice :");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Reader in = null;
		BufferedReader br1=new BufferedReader(in, 8);
		*/
//		String s = br.readLine();
//	choice = Integer.parseInt(s);
		New n1=new New(10,20);
		n1.fun("raj");
		New n2= (New) n1.co();
		n2.fun("raj");
		System.out.println((n1.co().getClass()== n1.getClass()));
		System.out.println();
		System.out.println(n1.s1);
		System.out.println(n2.s1);
		System.out.println(n1.getClass());
		System.out.println(n2.getClass());
		System.out.println(n1.equals(n2));
		New n3;
		n3=n2;
		System.out.println(n3.a+" "+n3.b);
	}

}


class New implements Cloneable{
	int a, b;
	New(int a, int b){
		this.a=a;
		this.b=b;
	}
		
	String s1=new String("vasanth");

	int i,arr[]={0};
	
	public Object co() throws CloneNotSupportedException{
		return super.clone();
	}
	String fun(String s2){
		this.s1=s2;
		return s1;
		
	}
}

 
/*
import java.util.*;

public class Check{
  public static void main(String[] args){

  Employee emp = new Employee("Amardeep", 50000);
  emp.setHireDay(2005,0,0);
  Employee emp1 = (Employee)emp.clone();
  emp1.raiseSalary(20);
  emp1.setHireDay(2008, 12, 31);
  System.out.println("Employee=" + emp);
  System.out.println("copy=" + emp1);
  }
}
class Employee implements Cloneable{
  		public Employee(String str, double dou){
  				name = str;
  				salary = dou;
  	}
  
  public Object clone(){
  	try{
  		Employee cloned = (Employee)super.clone();
  		cloned.hireDay = (Date)hireDay.clone();
  		return cloned;
  		}
  catch(CloneNotSupportedException e){
  			System.out.println(e);
  			return null;
  		}
  }
  public void setHireDay(int year, int month, int day){
  				hireDay = new GregorianCalendar(year,month - 1, day).getTime();
  }
  public void raiseSalary(double byPercent){
  				double raise = salary * byPercent/100;
  				salary += raise;
  }
  public String toString(){
  				return "[name=" + name+ ",salary=" + salary+ ",hireDay=" + hireDay+ "]";
  }
  private String name;
  private double salary;
  private Date hireDay;
}
 */


// Clone function example
/*

class Student implements Cloneable{  
int rollno;  
String name;  
  
Student(int rollno,String name){  
this.rollno=rollno;  
this.name=name;  
}  
  
public Object clone()throws CloneNotSupportedException{  
return super.clone();  
}  
  
public static void main(String args[]){  
try{  
Student s1=new Student(101,"amit");  
  
Student s2=(Student)s1.clone();  
  
System.out.println(s1.rollno+" "+s1.name);  
System.out.println(s2.rollno+" "+s2.name);  
  
}
catch(CloneNotSupportedException c){
	
}  
  
}  
} */ 