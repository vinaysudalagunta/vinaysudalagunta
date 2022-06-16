package com.zensar.beans;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	
	
	@Autowired
	private Department department;
	
	public Employee() {
		super();
	}
	
	
	
	public Employee(Department department) {
		super();
		this.department = department;
	}



	public Employee(int employeeId, String employeeNamee) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		
	}
	
	
	
	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", department=" + department
				+ "]";
	}
	
	
	
	
}