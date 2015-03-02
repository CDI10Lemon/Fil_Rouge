package fr.red.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.red.entity.Employee;
import fr.red.entity.Structure;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class StructureService implements StructureServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StructureService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee findPersonById(Employee employee) {
		return entityManager.find(Employee.class, employee.getIdEmployee());
	}

	@Override
	public List<Employee> findEmployeeAll() {
		return entityManager.createNamedQuery("Employee.findAll")
				.getResultList();
	}

	@Override
	public List<Structure> findAllClass() {
		return entityManager.createNamedQuery("Structure.findAll")
				.getResultList();
	}

	@Override
	public Structure findStructureById(Structure structure) {
		return entityManager.find(Structure.class, structure.getIdStructure());
	}

}