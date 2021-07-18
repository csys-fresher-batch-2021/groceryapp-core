package in.grocery.model;

public class Customers {

	int cusId;
	String cusName;
	String cusAddress;
	Long cusMobileNo;
	String cusPassword;
	String cusStatus;

	public Customers(int cusId, String cusName, String cusAddress, Long cusMobileNo, String cusPassword,
			String cusStatus) {

		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAddress = cusAddress;
		this.cusMobileNo = cusMobileNo;
		this.cusPassword = cusPassword;
		this.cusStatus = cusStatus;
	}

	public Customers() {
		
	}

	@Override
	public String toString() {
		return "Customers [cusId=" + cusId + ", cusName=" + cusName + ", cusAddress=" + cusAddress + ", cusMobileNo="
				+ cusMobileNo + ", cusPassword=" + cusPassword + ", cusStatus=" + cusStatus + "]";
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public Long getCusMobileNo() {
		return cusMobileNo;
	}

	public void setCusMobileNo(Long cusMobileNo) {
		this.cusMobileNo = cusMobileNo;
	}

	public String getCusPassword() {
		return cusPassword;
	}

	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}

	public String getCusStatus() {
		return cusStatus;
	}

	public void setCusStatus(String cusStatus) {
		this.cusStatus = cusStatus;
	}

}
