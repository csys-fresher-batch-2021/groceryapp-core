package in.grocery.model;

public class Employee {

	int empId;
	String empName;
	String empAddress;
	Long empMobileNo;
	String empPassword;

	public Employee(int empId, String empName, String empAddress, Long empMobileNo, String empPassword) {

		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empMobileNo = empMobileNo;
		this.empPassword = empPassword;
	}

	public Employee() {

	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empMobileNo="
				+ empMobileNo + ", empPassword=" + empPassword + "]";
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public Long getEmpMobileNo() {
		return empMobileNo;
	}

	public void setEmpMobileNo(Long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

}
