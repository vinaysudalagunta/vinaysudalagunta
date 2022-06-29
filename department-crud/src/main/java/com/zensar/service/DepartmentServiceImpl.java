package com.zensar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return department;
	}

	@Override
	public List<Department> fetchDepartmentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		
	}
	

}
