package mainService;
import java.lang.*;
public class InterfaceFixed implements InterfaceService1{

	double principal,time, rate;
	@Override
	public void Interest(double p,double t,double r) {
		// TODO Auto-generated method stub
		this.principal=p;
		this.time=t;
		this.rate=r;
		double temp=rate/400;
		double value=(1+(temp));
		double maturity;
		maturity=principal*(Math.pow(value, time*4));
		
		System.out.println("Interest Earned in Fixed= "+(maturity-this.principal));
		System.out.println("Total Maturity amount after "+time+"years="+maturity);
		
	}
	/*	This constructor was used when, I used it for creating the object directly 
	 * in the interface Demo Program
	public InterfaceFixed(double p,double t,double r) {
		// TODO Auto-generated constructor stub
			this.principal=p;
			this.time=t;
			this.rate=r;
	}*/

}
