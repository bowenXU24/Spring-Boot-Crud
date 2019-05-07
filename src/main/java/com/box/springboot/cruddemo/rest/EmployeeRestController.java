package com.box.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.box.springboot.cruddemo.dao.EmployeeDAO;
import com.box.springboot.cruddemo.entity.Employee;
import com.box.springboot.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
		private EmployeeService employeeService;
		
		@Autowired
		public EmployeeRestController(EmployeeService employeeService) {
			this.employeeService = employeeService;
		}
		
		//expose "/employee" and return list
		
		@GetMapping("/employees")
		public List<Employee> findAll(){
			return  employeeService.findAll();
		}
	

}
