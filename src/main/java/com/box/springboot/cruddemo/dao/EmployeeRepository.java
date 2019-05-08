package com.box.springboot.cruddemo.dao;

import com.box.springboot.cruddemo.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    
}