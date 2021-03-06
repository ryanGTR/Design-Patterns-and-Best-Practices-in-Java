package com.employee.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
/**
 * This class implements GET and POST methods for Employee Entity
 */
public class EmployeeWebService {
	
	/**
	 * This method generates Employee data report and emails it to admin. This also
	 * returns number of employees in the system currently.
	 * 
	 * @return EmployeeCount
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/report")
	public List<Employee> EmployeeReport() throws ServletException, IOException {
		System.out.println("Starting report generation");
		// Lets say this method gets all EmployeeDetailss First
		List<Employee> empList = new EmployeeService().getEmployees();
		// Say there is a ReportUtil which takes the list data, does some calculations
		// and dumps the report at a specific location
		String reportPath = ReportUtil.generateReport();
		// Finally say we have an email service which picks the report and send to admin.
		EmailUtil.sendReport(reportPath);
		// Finally return the employee's count
		System.out.println("Ending report generation");
		return empList;
	}

}

/**
 * This is a dummy class for example purpose.
 * 
 */
class EmployeeService{
	public List<Employee> getEmployees() {
		System.out.println("In list Employees");
		// This will actually fetch data from database and retunr employee list
		return null;
	}
}

/**
 * This is a dummy class for example purpose.
 * 
 */
class ReportUtil{
	public static String generateReport() {
		System.out.println("in get generateReport");
		return null;
	}
}

/**
 * This is a dummy class for example purpose.
 * 
 */
class EmailUtil{
	public static void sendReport(String path) {
		System.out.println("in get sendReport");
	}
}

class Employee {
	String name;
	String id;
	String designation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
