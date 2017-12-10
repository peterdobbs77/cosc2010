package assign6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompanyDemo {

	static Map<String, Department> departments = new HashMap<String, Department>();
	static Map<String, Employee> employees = new HashMap<String, Employee>();

	/**
	 * 
	 * @param emp
	 *            employee object for listing department information
	 */
	private static void listDepartmentInfo(Employee emp) {
		Department temp = departments.get(emp.getDepartmentNum());
		System.out.println(temp.getName() + ": " + temp.getNumber());
	}

	/**
	 * 
	 * @param emp
	 *            employee object for listing supervisors
	 */
	private static void listSupervisors(Employee emp) {
		String sup = emp.getSupervisor();
		if (sup.equals("")) {
			System.out.println("This is the department manager");
			return;
		} else {
			System.out.println(employees.get(sup).getName());
			listSupervisors(employees.get(sup));
		}
	}

	public static void main(String[] args) throws Exception {
		/* Setup the company */
		String fName = "";
		String line = null;
		try {
			fName = "DEPARTMENT.txt";
			FileReader fr = new FileReader(fName);
			BufferedReader buff = new BufferedReader(fr);
			while ((line = buff.readLine()) != null) {
				String contents[] = line.split(",");
				Department newDepartment = new Department(contents[0],
						contents[1], contents[2], contents[3]);
				departments.put(contents[1], newDepartment);
			}
			buff.close();
			fName = "EMPLOYEE.txt";
			fr = new FileReader(fName);
			buff = new BufferedReader(fr);
			line = buff.readLine(); // skip first line
			while ((line = buff.readLine()) != null) {
				String contents[] = line.split(",");
				Employee newEmployee = new Employee(contents[0] + " "
						+ contents[1], contents[2], contents[3], contents[4]
						+ contents[5] + contents[6], contents[7], contents[8],
						contents[9]);
				employees.put(contents[2], newEmployee);
			}
			buff.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fName + "'");
		}

		/* Begin User Experience */
		boolean userWantsInformation = true;
		Scanner scan = new Scanner(System.in);
		while (userWantsInformation) {
			System.out.println("Enter a valid employee SSN");
			String ssn = scan.next();
			Employee emp = employees.get(ssn);
			if (emp == null) {
				System.out.println("Error: Invalid Employee SSN\n");
				continue;
			}
			System.out.println(emp.getName());
			System.out.println("Choose an operation:");
			System.out
					.println("Enter 1 for department name and number where employee works");
			System.out
					.println("Enter 2 to list all supervisors of the employee.");
			System.out.println("Enter 3 to exit this program.");
			int response = scan.nextInt();
			switch (response) {
			case 1:
				listDepartmentInfo(emp);
				break;
			case 2:
				listSupervisors(emp);
				break;
			case 3:
				userWantsInformation = false;
				break;
			default:
				break;
			}
			System.out.println();
		}
		scan.close();
	}

}
