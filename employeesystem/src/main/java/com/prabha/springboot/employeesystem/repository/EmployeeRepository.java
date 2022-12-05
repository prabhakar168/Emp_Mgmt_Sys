package com.prabha.springboot.employeesystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.prabha.springboot.employeesystem.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
