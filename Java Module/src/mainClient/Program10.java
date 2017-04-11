// Abstract Class
package mainClient;
abstract class high{

int temp1;
final static int temp2=10;
static int temp3;

// Constructor

	protected high(){
			System.out.println("High Class Constructor");
	}

	public abstract void calc1();
	public void calc2(){
		System.out.println(" Values of the resultant variables="+(temp1+temp2+temp3));
	}	
}

abstract class medium extends high{
	medium(){
		super();   // Have used Protected in order to make it work 
		System.out.println("Medium Class Construcor");
	}

public abstract void calc3();
}

class low extends medium {
public void calc1(){
	System.out.println(" Values of the resultant variables="+(temp1+temp2+temp3));
	}
public void calc3(){

	}	
}

public class Program10{
public static void main(String[] args){
low l1=new low();
l1.calc1();
}
}