package com.prabha.springboot.employeesystem.service;

import com.prabha.springboot.employeesystem.entity.Employee;

public interface EmployeeService {

	Employee insert(Employee empl);

	Iterable<Employee> getemp();

	Employee updateemp(Long id,double salary);

	void deleteemp(Long id);

}
