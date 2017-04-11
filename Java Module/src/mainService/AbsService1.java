package mainService;

import java.io.Serializable;

public class AbsService1 extends AbsService implements Serializable{

	public AbsService1(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Run() {
		// TODO Auto-generated method stub
		System.out.println("Distance Cover in sub ="+(super.end-super.start));
		
	}

}
