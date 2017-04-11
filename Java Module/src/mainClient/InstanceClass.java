package mainClient;

import mainService.DemoInterface;
import mainService.InstanceOperationMain;
import mainService.InstanceOperationSub;
import mainService.InstanceOperationSub1;

public class InstanceClass  extends InstanceOperationSub{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * It is static binding, object is determined at Compile Time. 
		 */
		 InstanceOperationMain i1=new InstanceOperationMain();
		 /*
		  * Below Object i2 is example for Dynamic Binding.
		  * It is a Dynamic Binding, Object is determined at Run Time. 
		  */
		 InstanceOperationMain i2=new InstanceOperationSub();
		 /*
		  * This will evaluate whether i2 is a Instanceof Operator Main, 
		  * i2 Object is sub class object of InstanceOperationMain.
		  */
		 System.out.println(i2 instanceof InstanceOperationMain );
		/*
		 * The below mentioned Object Creation will report Class Cast Exception, so It can't be downcasted using typecasting.
		 * InstanceOperationSub i3=(InstanceOperationSub)new InstanceOperationMain();
		 */
		 InstanceOperationSub i3=(InstanceOperationSub)i2;
		 System.out.println(i3 instanceof InstanceOperationSub);
		 
		 /*
		  * Usage of InstanceOf operator in the class defined in the class DecisionCall
		  * 
		  */
		 InstanceOperationSub i4=new InstanceOperationSub();
		 
		 InstanceOperationSub1 i5=new InstanceOperationSub1();
		 /*
		  * Decision of which methods needs to invoked is made in DecisionCall.java file, it is based for which class object is created.
		  */
		 i4.showDemo();
		 i5.showDemo();
		 
	}

}
