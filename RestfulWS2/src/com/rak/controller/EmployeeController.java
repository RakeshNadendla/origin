package com.rak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rak.model.Employee;
import com.rak.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		int eid = employeeService.addEmployee(employee);
		return ResponseEntity.ok("Employee added successfully" + eid);
	}

	@GetMapping("/employee{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int eid) {
		Employee employee = employeeService.getEmployee(eid);
		return ResponseEntity.ok().body(employee);

	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok().body(employees);
	}

	@PutMapping("/employee{eid}")
	public ResponseEntity<?> updateEmployee(@PathVariable("eid") int eid, @RequestBody Employee employee) {
		employeeService.updateEmployee(eid, employee);
		return ResponseEntity.ok().body("Employee Updated Successfully--" + eid);

	}

	@DeleteMapping("/employee{eid}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("eid") int eid) {
		employeeService.deleteEmployee(eid);
		return ResponseEntity.ok().body("Employee deleted Successfully--" + eid);

	}

}
