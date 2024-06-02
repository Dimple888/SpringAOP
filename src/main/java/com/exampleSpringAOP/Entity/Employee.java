package com.exampleSpringAOP.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//	private Date currentDate; -- "currentDate": "2024-04-23 10:08:02",
	
	private long projectId;

}
