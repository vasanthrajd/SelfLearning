package mainClient;
// Dynamic Method Dispatch 
// Instance method are invoked based on object created, whereas in Instance Method are invoked based on class created is on class. 

class grandparent{
	
int gp=1000;

grandparent(){
System.out.println("Grand Parent Constructor");
}

public void property(){
	System.out.println("Grand Property = "+gp);
}

}
class parent extends grandparent{
int pp=500;

parent(){
System.out.println("Parent Constructor");
}
//@ Override the method of base class "grandparent"
public void property(){
System.out.println("Parent Property ="+ (gp+pp));
}
}
class child extends grandparent{
int cp=750;

child(){
System.out.println("Child Constructor");
}
//@ Override the method of base class "grandparent"
public void property(){
System.out.println("Child Property ="+ (gp+cp));
}
}

class Program8{
public static void main(String[] args){

grandparent gp=new grandparent();
parent pp=new parent();
child cp=new child();

grandparent g1;
g1=cp;
g1.property();
if(g1 instanceof parent)
	System.out.println("Current Object Reference by G1 is="+g1.getClass().getName());
if(g1 instanceof child)
	System.out.println("Current Object Reference by G1 is="+g1.getClass().getName());
	
}
}