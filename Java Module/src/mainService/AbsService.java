package mainService;

public abstract class AbsService {
	 public int start;
	 public int end;
	public  void Run(){
		System.out.println("Distance Cover in Super ="+(this.end-this.start));
	}
	
	public AbsService(int x,int y){
		this.start=x;
		this.end=y;
	}
	}

