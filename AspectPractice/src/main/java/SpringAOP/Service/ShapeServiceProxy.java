package SpringAOP.Service;

import SpringAOP.Aspect.LoggingAspect;
import SpringAOP.Model.Circle;

public class ShapeServiceProxy extends ShapeService {

	public Circle getCircle(){
		new LoggingAspect().loggingAdvice();;
		
		return super.getCircle();
	}
	
}
