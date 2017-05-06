package SpringAOP.Model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle Setter Method");
		throw(new RuntimeException());
	}
	public String setNameandReturning(String name) {
		this.name = name;
		System.out.println("Circle Setter Method");
		return name+"setNameandReturning";
	}
	
	public String showName(){
		return "Getter Method :"+this.name;
	}
	
}
