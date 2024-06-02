package com.exampleSpringAOP.aopdemo;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.exampleSpringAOP.Entity.Employee;

@Aspect
@Component
public class EmployeeAspect {
	
	@Before(value = "execution(* com.exampleSpringAOP.Controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Request to" + joinPoint.getSignature() + "started at" +  new java.sql.Date(System.currentTimeMillis()));
	}
	
	@After(value = "execution(* com.exampleSpringAOP.Controller.EmployeeController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Request to" + joinPoint.getSignature() + "ended at" +  new java.sql.Date(System.currentTimeMillis()));
	}
	
	//for service class for specific method
	
	@Before(value = "execution(* com.exampleSpringAOP.Service.EmpService.getAllEmployee(..))")
	public void beforeAdviceEmpService(JoinPoint joinPoint) {
		System.out.println("Request to" + joinPoint.getSignature() + "started at" +  new java.sql.Date(System.currentTimeMillis()));
	}
	
	@After(value = "execution(* com.exampleSpringAOP.Service.EmpService.getAllEmployee(..))")
	public void afterAdviceEmpService(JoinPoint joinPoint) {
		System.out.println("Request to" + joinPoint.getSignature() + "ended at" +  new java.sql.Date(System.currentTimeMillis()));	
	}
	
	@AfterReturning(value = "execution(* com.exampleSpringAOP.Service.EmpService.saveEmp(..))",returning = "employee")
	public void afterReturningAdviceEmpService(JoinPoint joinPoint,List<Employee> employee) {
		System.out.println("Business logicc to save an employee ran succesfully and employee is saved with id"+ employee.toString() +new java.sql.Date(System.currentTimeMillis()));
	}
	
	@AfterThrowing(value = "execution(* com.exampleSpringAOP.Service.EmpService.saveEmp(..))",throwing = "exception")
	public void afterThrowingAdviceEmpService(JoinPoint joinPoint,Exception exception) {
		System.out.println("Buiness logic to save employee throws an exception" + exception.getMessage()+ new java.sql.Date(System.currentTimeMillis()));
	}
	
	@Around(value = "execution(* com.exampleSpringAOP.Service.EmpService.saveEmp(..))")
	public Employee aroundAdviceForEmpAddService(ProceedingJoinPoint joinPoint) {
		System.out.println("Inside around adive in aspect: Business logic to save emp started at"+ new java.sql.Date(System.currentTimeMillis()));
		
		try {
			Employee[] empArr = new Employee[1];
			Employee dummy = new Employee();
			dummy.setName("dummy");
			empArr[0] = dummy;
			Employee emp = (Employee)joinPoint.proceed(); //it takes array of object so created Employee[] and typecasted to Employee
			return emp;
		}catch(Throwable ex) {
			System.out.println("Inside around adive in aspect: Business logic to save emp failed terribly"+ ex.getMessage());
		}
		System.out.println("Inside around adive in aspect: Business logic to save emp ended at "+ new java.sql.Date(System.currentTimeMillis()));
		return null;
	}
	
	

}
