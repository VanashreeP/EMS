package com.employee.Employee.Service.Impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee.Entity.Employee;
import com.employee.Employee.Exception.ResourceNotFoundException;
import com.employee.Employee.Repository.EmployeeRepository;
import com.employee.Employee.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public Employee saveEmployee(Employee e) {
		return repository.save(e);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id)  {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Employee with Id:"+id));
	}

	@Override
	public List<Employee> getAllEmployeesInDescendingOrderBySalary() {
		List<Employee> list=repository.findAll().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
		list.forEach(e ->System.out.println("Id:"+e.getId()+" Name:"+e.getName()+" Salary:"+e.getSalary()+" Designation:"+e.getDesignation()));
		return list;
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1=repository.findById(e.getId()).orElse(null);
		e1.setName(e.getName());
		e1.setSalary(e.getSalary());
		e1.setDesignation(e.getDesignation());
		return e1;
	}

	@Override
	public String deleteEmployee(long id) {
		repository.deleteById(id);
		return "Employe deleted by ID:"+id;
	}
	
}
