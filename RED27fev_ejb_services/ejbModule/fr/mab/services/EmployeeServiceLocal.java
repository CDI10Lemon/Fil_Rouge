package fr.mab.services;

import java.util.List;

import javax.ejb.Local;

import fr.mab.model.Employee;

@Local
public interface EmployeeServiceLocal {
	
	Employee findById(Employee employee);

	List<Employee> findAll();

	void delete(Employee employee);

	Employee update(Employee employee);

	Employee create(Employee employee);
}
