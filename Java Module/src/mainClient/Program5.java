package mainClient;
// if a class is declared as a public, then JVM expects that class to be defined as a separate file.

class superClass{

int a=20;
void add(){
	System.out.println( "super class addition" + (a+40) );
}

}
class childClass extends superClass{

int b=10;

public void add(){
	if ( a<b )
	{
	System.out.println( "child class addition" + (a+b) );
	}
	else
	{
		super.add();
	}

}

public void sub(){
	System.out.println( a-b );
}

}

class Program5{
public static void main(String[] args){
childClass c1=new childClass();
c1.add();		// Will inherit the super class method add();
c1.sub();
}

	}