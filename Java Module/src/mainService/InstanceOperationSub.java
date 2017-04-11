package mainService;

public class InstanceOperationSub extends InstanceOperationMain implements DemoInterface  {
	public void showDemo(){
		System.out.println("InstanceOperationSub showDemo() Implementation and value of A defined "+a);
	}
}
