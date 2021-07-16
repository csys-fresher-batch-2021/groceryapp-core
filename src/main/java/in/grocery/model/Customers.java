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

	@Override
	public String toString() {
		return "Customers [cusId=" + cusId + ", cusName=" + cusName + ", cusAddress=" + cusAddress + ", cusMobileNo="
				+ cusMobileNo + ", cusPassword=" + cusPassword + ", cusStatus=" + cusStatus + "]";
	}


}
