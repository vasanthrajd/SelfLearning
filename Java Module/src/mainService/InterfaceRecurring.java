package mainService;
import java.lang.*;
public class InterfaceRecurring implements InterfaceService1{

	double principal,time, rate;
	@Override
	public void Interest(double p,double t,double r) {
		// TODO Auto-generated method stub
		this.principal=p;
		this.time=t;
		this.rate=r;
		double temp=rate/400;
		double value=(1+(temp));
		double maturity=(this.principal*((Math.pow(value, time/3))-1))/(1-((Math.pow(value, (-0.333)))));
		
		
//		System.out.println(1-((Math.pow(value, (-0.333)))));
		System.out.println("Interest Earned in Recurring= "+(maturity-this.principal*time));
		System.out.println("Total Maturity amount after "+ time +" quarters="+maturity);
		
	}

/*	This constructor was used when, I used it for creating the object directly 
 * in the interface Demo Program
 * 
 * public InterfaceRecurring(double p,double t,double r) {
		// TODO Auto-generated constructor stub
		this.principal=p;
		this.time=t;
		this.rate=r;
}*/

	
}
