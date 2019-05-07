package com.box.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.box.springboot.cruddemo.dao.EmployeeDAO;
import com.box.springboot.cruddemo.entity.Employee;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
		//inject employee DAO
		
		private EmployeeDAO employeeDAO;
		
		@Autowired
		public EmployeeRestController(EmployeeDAO employeeDAO) {
			 this.employeeDAO =  employeeDAO;
		}
		
		//expose "/employee" and return list
		
		@GetMapping("/employees")
		public List<Employee> findAll(){
			return  employeeDAO.findAll();
		}
	

}
