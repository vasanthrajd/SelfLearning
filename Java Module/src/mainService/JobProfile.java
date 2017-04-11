package mainService;

public class JobProfile implements Comparable<JobProfile> {

	private String name;
	private String jobDesc;
	private Integer expr;
	private String domain;
	private Integer salaryExpected;
	public JobProfile(String name, String jobDesc, Integer expr, String domain,
			Integer salaryExpected) {
		super();
		this.name = name;
		this.jobDesc = jobDesc;
		this.expr = expr;
		this.domain = domain;
		this.salaryExpected = salaryExpected;
	}
	@Override
	public String toString() {
		return "JobProfile [Name=" + name + ", jobDescription=" + jobDesc + ", yrs of expr="
				+ expr + ", domain=" + domain + ", salaryExpected="
				+ salaryExpected + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
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
	public Integer getSalaryExpected() {
		return salaryExpected;
	}
	public void setSalaryExpected(Integer salaryExpected) {
		this.salaryExpected = salaryExpected;
	}
	@Override
	public int compareTo(JobProfile o) {
		// TODO Auto-generated method stub
		if(this.expr > o.expr){
			return -1;
		}else if(this.expr < o.expr){
			return 1;
		}
		return 0;
	}
	
}
