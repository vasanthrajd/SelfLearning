package mainClient;
//Composition ( Strong Has a Relationship ) 

class Bank{
//Object reference should also be mentioned private final 

private final Account acc;

Bank(String accName, int accNo, int balance){
	acc=new Account(accName, accNo, balance);
}

public void getDetails(){
	acc.getValue();
}
private class Account{

	//providing the private access modifier for the class will result in Strong Has A Relationship, 
	
	String accName;
	int accNo;
	int balance;

	Account(String accName, int accNo, int balance){
		this.accName=accName;
		this.accNo=accNo;
		this.balance=balance;
		
	}

	public void getValue(){
		System.out.println(" Account Holder's details:");
		System.out.println(" Account Holder's Name="+accName

	+"\tacc No:"+accNo+"\tacc Balance:"+balance);
	}
}
}
class Program9{
public static void main(String[] args){
	Bank b1=new Bank("Newton",99444,82734);
	b1.getDetails();
/*Account ac1=new Account("Issac",99443,833734);
	ac1.getValue();
	System.out.println(ac1.a+"/"+ac1.b+"/"+ac1.c);
	System.out.println("Object Class 

hashCode="+ac1.hashCode());
	System.out.println("Object Class 

toString="+ac1.toString());
	System.out.println("Object Class 

toString="+ac1.getClass());
*/	
}
}