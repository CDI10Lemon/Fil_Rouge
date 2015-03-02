package fr.red.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.red.entity.Employee;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class EmployeeService implements EmployeeServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee findById(Employee employee) {
		return entityManager.find(Employee.class, employee.getIdEmployee());
	}

	@Override
	public List<Employee> findAll() {
		return entityManager.createNamedQuery("Employee.findAll")
				.getResultList();
	}

}