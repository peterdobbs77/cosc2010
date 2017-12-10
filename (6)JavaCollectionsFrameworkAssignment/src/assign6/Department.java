package assign6;

import java.util.HashSet;

public class Department {
	private String name;
	private String number;
	private String manager;
	private String managerStart;
	public HashSet<Employee> employees;

	public Department(String name, String number, String manager,
			String managerStart) {
		this.name = name;
		this.number = number;
		this.manager = manager;
		this.managerStart = managerStart;
	}

	/**
	 * gets the name of the department
	 * 
	 * @return the name of the department
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the number of the department
	 * 
	 * @return the number of the department
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * gets the department manager
	 * 
	 * @return the ssn of the department manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * sets the department manager
	 * 
	 * @param manager
	 *            ssn of the department manager
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	/**
	 * gets the start date for the department manager
	 * 
	 * @return department manager's start date
	 */
	public String getManagerStart() {
		return managerStart;
	}

	/**
	 * sets the start date for the department manager
	 * 
	 * @param managerStart
	 *            department manager's start date
	 */
	public void setManagerStart(String managerStart) {
		this.managerStart = managerStart;
	}

}
