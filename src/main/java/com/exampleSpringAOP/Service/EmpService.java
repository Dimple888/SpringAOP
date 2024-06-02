package com.exampleSpringAOP.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleSpringAOP.Entity.Employee;
import com.exampleSpringAOP.Repository.EmpRespository;

@Service
public class EmpService {
	
	@Autowired
	EmpRespository empRespository;
	
	public List<Employee> getAllEmployee() {

		return empRespository.findAll();

	}
	
	public Employee saveEmployee(Employee emp) {

		return empRespository.save(emp);

	}

}
