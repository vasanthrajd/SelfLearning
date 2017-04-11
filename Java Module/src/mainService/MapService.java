package mainService;

public class MapService {

	public  int accNo;
	private String name;
	private String accType;
	private double accBalance;
	public MapService(int accNo, String name, String accType, double accBalance) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.accType = accType;
		this.accBalance = accBalance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account Details [ \n"+ "Acc No--" + accNo +"\nAccount Holder Name--"+ name + 
				"\nAccount Type--"+	accType+"\nAccount Balance--"+ accBalance +"]";
	}
	
	
}
