package assign6;

public class Employee {
	private String name;
	private String SSN;
	private String address;
	private String salary;
	private String departmentNum;
	private String DOB;
	private String supervisor;

	public Employee(String name, String ssn, String dob, String address,
			String salary, String supervisor, String departmentNum) {
		this.name = name;
		this.SSN = ssn;
		this.address = address;
		this.salary = salary;
		this.departmentNum = departmentNum;
		this.DOB = dob;
		this.supervisor = supervisor;
	}

	/**
	 * gets the employee name
	 * 
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the employee ssn
	 * 
	 * @return ssn of the employee
	 */
	public String getSSN() {
		return SSN;
	}

	/**
	 * gets the employee address
	 * 
	 * @return address of the employee
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * sets the employee address
	 * 
	 * @param address
	 *            address of the employee
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * gets the employee salary
	 * 
	 * @return salary of the employee
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * sets the employee salary
	 * 
	 * @param salary
	 *            salary of the employee
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/**
	 * gets the number of the employee's department
	 * 
	 * @return department number where employee works
	 */
	public String getDepartmentNum() {
		return departmentNum;
	}

	/**
	 * sets the number of the employee's department
	 * 
	 * @param departmentNum
	 *            number of department where employee works
	 */
	public void setDepartmentNum(String departmentNum) {
		this.departmentNum = departmentNum;
	}

	/**
	 * gets the date of birth of the employee
	 * 
	 * @return date of birth of the employee
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * sets the employee's supervisor
	 * 
	 * @param supervisor
	 *            supervisor's ssn
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * gets the employee's supervisor
	 * 
	 * @return the supervisor's ssn
	 */
	public String getSupervisor() {
		return supervisor;
	}
}
