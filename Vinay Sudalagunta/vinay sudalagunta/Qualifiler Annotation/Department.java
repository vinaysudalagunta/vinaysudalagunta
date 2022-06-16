package com.zensar.beans;

public class Department {
	
	private int departmentCode;
	private String departmentRole;
	
	public Department() {
		super();
	}

	public Department(int departmentCode, String departmentRole) {
		super();
		this.departmentCode = departmentCode;
		this.departmentRole = departmentRole;
	}

	public int getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(int departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentRole() {
		return departmentRole;
	}

	public void setDepartmentRole(String departmentRole) {
		this.departmentRole = departmentRole;
	}

	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode + ", departmentRole=" + departmentRole + "]";
	}
	
	

}