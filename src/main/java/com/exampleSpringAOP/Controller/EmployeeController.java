package com.exampleSpringAOP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleSpringAOP.Entity.Employee;
import com.exampleSpringAOP.Service.EmpService;


@RestController
@RequestMapping("/aopemployee")
public class EmployeeController {
	
	@Autowired
	EmpService empService;

	@GetMapping("/fetchall")
	public ResponseEntity<List<Employee>> getAllEmployess(){
		
		return new ResponseEntity<>(empService.getAllEmployee(),HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
		
		return new ResponseEntity<>(empService.saveEmployee(emp),HttpStatus.OK);
		
	}
}
