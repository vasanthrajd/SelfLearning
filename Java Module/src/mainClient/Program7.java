package mainClient;
class PriCons{

// Instance Variable declared with Private Static PriCons can hold object for the class PriCons, by doing so we can limit the number of creation of the object.

private static PriCons instance=null;


private PriCons(){
System.out.println("Private Constrcutor for preventing creation of the object");
}

public static PriCons getInstance(){
	instance=new PriCons();
	return instance;
}

}

class Program7{

public static void main(String[] args){
//		PriCons p1=new PriCons();
		PriCons.getInstance();
}

}