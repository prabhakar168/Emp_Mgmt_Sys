package com.prabha.springboot.employeesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabha.springboot.employeesystem.entity.Employee;
import com.prabha.springboot.employeesystem.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	EmployeeService serv;
	
	@PostMapping
	public Employee save(@RequestBody Employee empl)
	{
		return serv.insert(empl);
	}
	
	@GetMapping
	public Iterable<Employee> getting()
	{
		return serv.getemp();
	}
	
	@PutMapping("/{id}")
	public Employee updateemp(@PathVariable Long id,@RequestBody double salary)
	{
		return serv.updateemp(id,salary);
	}
	
	@DeleteMapping("/{id}")
	public String deleteemp(@PathVariable Long id)
	{
		serv.deleteemp(id);
		return "deleted -"+id;
	}
}
