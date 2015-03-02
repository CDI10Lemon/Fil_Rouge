package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Employee;

@Stateless
public class EmployeeService implements EmployeeServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	public EmployeeService() {

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

	@Override
	public void delete(Employee employee) {
		employee = entityManager.merge(employee);
		entityManager.remove(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public Employee create(Employee employee) {
		entityManager.persist(employee);
		return employee;
	}

}
