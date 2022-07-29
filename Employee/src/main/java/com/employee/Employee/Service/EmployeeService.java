package com.employee.Employee.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.employee.Employee.Entity.Employee;

@Component
public interface EmployeeService {
	
	public Employee saveEmployee(Employee e);
	public List<Employee> getAllEmployee();	
	public Employee getEmployeeById(long id);
	public Employee updateEmployee(Employee e);
	public String deleteEmployee(long id);
	public List<Employee> getAllEmployeesInDescendingOrderBySalary();
	
}
