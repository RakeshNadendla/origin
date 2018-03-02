package com.rak.dao;

import java.util.List;

import com.rak.model.Employee;

public interface EmployeeDao {
	
	int addEmployee(Employee employee);

	Employee getEmployee(int eid);	

	List<Employee> getAllEmployees();
	
	void updateEmployee(int eid,Employee employee);
	
	void deleteEmployee(int eid);

}
