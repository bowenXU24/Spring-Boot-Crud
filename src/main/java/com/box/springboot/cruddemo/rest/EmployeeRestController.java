package com.box.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

		//get employee by id
		@GetMapping("/employees/{employeeId}")
		public Employee getEmployeeById(@PathVariable int employeeId){
			
			Employee theEmployee = employeeService.findById(employeeId);

			if(theEmployee==null){
				throw new RuntimeException("Employee not fonud with id " + employeeId);
			}

			return theEmployee;
		}

		//add employee
		@PostMapping("/employees")
		public Employee addEmployee(@RequestBody Employee theEmployee){

			//set id to 0
			theEmployee.setId(0);

			employeeService.save(theEmployee);

			return theEmployee;
		}

		//update employee
		@PutMapping("/employees")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {

			employeeService.save(theEmployee);

			return theEmployee;
		}

		//delete employee
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId){

			Employee tempEmployee = employeeService.findById(employeeId);

			if(tempEmployee == null){
				throw new RuntimeException("Employee not found - " + employeeId);
			}
			
			employeeService.deleteById(employeeId);

			return "Delete success : " + employeeId;

		}
	

}
