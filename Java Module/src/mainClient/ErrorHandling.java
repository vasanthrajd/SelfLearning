package mainClient;

import java.io.File;

public class ErrorHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bclass b1=new Bclass();
		b1.check();
	}
	
}
class Aclass{
	public void check(){
		System.out.println("Check Method in AClass");
	}
}
class Bclass extends Aclass{
	public void check() {
			File f=new File("c:/abc.txt");
						
			//System.out.println("Check Method in BClass"+(10/0));
		
	}
}