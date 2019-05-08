package com.box.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.box.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		//create query
		
		Query theQuery = entityManager.createQuery("from Employee");
		//get result
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		//if id==0, then insert/save 
		Employee dbEmployee = entityManager.merge(theEmployee);

		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {

		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();
	}

}
