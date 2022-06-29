package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	

}
