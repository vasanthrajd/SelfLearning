package mainService;

public class DecisionCall {
	public void decisionCall(DemoInterface d){
			if(d instanceof InstanceOperationSub){
				d.showDemo();
			}
			if(d instanceof InstanceOperationSub1){
				d.showDemo();
			}
	}
}
