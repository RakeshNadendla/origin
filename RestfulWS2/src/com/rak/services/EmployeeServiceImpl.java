package com.rak.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rak.dao.EmployeeDao;
import com.rak.model.Employee;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;

	@Transactional
	@Override
	public int addEmployee(Employee employee) {

		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee getEmployee(int eid) {
		return employeeDao.getEmployee(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Transactional
	@Override
	public void updateEmployee(int eid, Employee employee) {
		employeeDao.updateEmployee(eid, employee);
	}

	@Transactional
	@Override
	public void deleteEmployee(int eid) {
		employeeDao.deleteEmployee(eid);
	}

}
