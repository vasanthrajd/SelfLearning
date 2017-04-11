package mainClient;

public class BasicClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MainClass m1=new MainClass();
			System.out.println(m1.x);
			m1.x=20;
			MainClass m2=new MainClass();
			System.out.println(m2.x);
			System.out.println(MainClass.x);
			MainClass.x=MainClass.x-20;
			System.out.println(MainClass.x);
			System.out.println(m1.x);
	}

}
class MainClass{
	private int i=10;
	protected int j=20;
	public int k=30;
	static int x=10;
}