package SpringAOP.Service;

import SpringAOP.Aspect.Loggable;
import SpringAOP.Model.Circle;
import SpringAOP.Model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle Getter Called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
	
}
