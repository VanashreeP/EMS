package com.employee.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Employee.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	void deleteById(int id);

	Optional<Employee> findById(int id);

}
