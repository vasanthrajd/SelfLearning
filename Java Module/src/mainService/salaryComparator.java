package mainService;

import java.util.Comparator;

public class salaryComparator implements Comparator<JobProfile> {

	@Override
	public int compare(JobProfile o1, JobProfile o2) {
		// TODO Auto-generated method stub
		if(o1.getExpr()>o2.getExpr()){
			return 1;
		}else if(o1.getExpr() < o2.getExpr()){
			return -1;
		}else {
			return 0;
			
		}
		
	}

		
	
}
