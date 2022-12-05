package com.prabha.springboot.employeesystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabha.springboot.employeesystem.entity.Employee;
import com.prabha.springboot.employeesystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplements implements EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	@Override
	public Employee insert(Employee empl) {
		// TODO Auto-generated method stub
		return repo.save(empl);
	}

	@Override
	public Iterable<Employee> getemp() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee updateemp(Long id,double salary) {
		// TODO Auto-generated method stub
		Employee emp=repo.findById(id).get();
		emp.setSalary(salary);
		return repo.save(emp) ;
	}

	@Override
	public void deleteemp(Long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
