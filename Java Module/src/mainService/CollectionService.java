package mainService;

public class CollectionService implements Comparable<CollectionService>{
	private int empId;
	private String Name;
	private String JobDesc;
	private Integer expr;
	private String domain;
	private Integer salExp;
	public CollectionService(int empId, String name, String jobDesc,
			Integer expr, String domain, Integer salExp) {
		super();
		this.empId = empId;
		this.Name = name;
		this.JobDesc = jobDesc;
		this.expr = expr;
		this.domain = domain;
		this.salExp = salExp;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getJobDesc() {
		return JobDesc;
	}
	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}
	public Integer getExpr() {
		return expr;
	}
	public void setExpr(Integer expr) {
		this.expr = expr;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Integer getSalExp() {
		return salExp;
	}
	public void setSalExp(Integer salExp) {
		this.salExp = salExp;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Job Profile [ empId "+this.empId + ", Name " +this.Name + ", JobDesc " + 
			this.JobDesc + ", Expr " + this.expr + ", domain " + this.domain  + ", domain " 
			+ ", Salary "+this.salExp+" ]";
		
		}
	@Override
	public int compareTo(CollectionService o) {
		// TODO Auto-generated method stub
		if(this.expr > o.expr){
			return -1;
		}else if(this.expr < o.expr){
			return 1;
		}else{
			if(this.salExp < o.salExp){
					return 1;
			}else if(this.salExp >o.salExp){
				return -1;
		}		
					return 0;
		}		
	}
	
}
