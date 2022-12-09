package com.prabha.springboot.employeesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.prabha.springboot.employeesystem.controller.EmployeeController;
import com.prabha.springboot.employeesystem.entity.Employee;
import com.prabha.springboot.employeesystem.service.EmployeeService;

@SpringBootTest
public class EmployeesystemApplicationTests {

	
	@Autowired
	private EmployeeController employ;
	@MockBean
	private EmployeeService serv;
	
	Employee emplo=new Employee();
	public void setup() 
	{
		emplo.setEmpId(854L);
		emplo.setFirstName("aravind");
		emplo.setLastName("sai");
		emplo.setAge(25);
		emplo.setSalary(720);
	}
	
	@Test
	public void saveTest() {
		when(serv.insert(emplo)).thenReturn(emplo);
		assertEquals(emplo,employ.save(emplo));
	}
	@Test
	public void gettingTest() {
		when(serv.getemp()).thenReturn(Stream.of(emplo).collect(Collectors.toList()));
		assertEquals(1, ((List<Employee>) employ.getting()).size());
	}
	@Test
	public void updateempTest() {
		Long id=984L;
		double salary=310;
		
		when(serv.updateemp(id,salary)).thenReturn(emplo);
		assertEquals(emplo,employ.updateemp(id,salary));
	}
	@Test
	public void deleteempTest() {
		long id=854;
		employ.deleteemp(id);
		verify(serv,times(1)).deleteemp(id);
	}
	
}
