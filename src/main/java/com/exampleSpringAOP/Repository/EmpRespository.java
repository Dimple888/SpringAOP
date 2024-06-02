package com.exampleSpringAOP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleSpringAOP.Entity.Employee;

@Repository
public interface EmpRespository extends JpaRepository<Employee,Integer> {
	
	List<Employee> findByName(String name);
	
	List<Employee> findAll();
	

}
