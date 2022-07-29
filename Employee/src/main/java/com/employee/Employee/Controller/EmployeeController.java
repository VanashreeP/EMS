package com.employee.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee.Entity.Employee;
import com.employee.Employee.Service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e) {
		return service.saveEmployee(e);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();		
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable long id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/employees/salary")
	public List<Employee> getAllEmployeesInDescendingOrderBySalary(){
		return service.getAllEmployeesInDescendingOrderBySalary();
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable long id) {
		return service.deleteEmployee(id);
	}
		
}
