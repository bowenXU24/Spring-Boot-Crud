package com.box.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.box.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//fields for EntityManager
	
	private EntityManager entityManager;
	
	//set up constructor injection
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	public List<Employee> findAll() {
		
		//get current hibernate session
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute qurey  get result
		
		List<Employee> employees = theQuery.getResultList();
		
		//return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		//get hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		//get Employee

		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(theEmployee);

	}

	@Override
	public void deleteById(int theId) {

		Session curerntSession = entityManager.unwrap(Session.class);

		//delete query
		Query theQuery = curerntSession.createQuery("delete from Employee where id=:employeeId");

		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();

	}

}
