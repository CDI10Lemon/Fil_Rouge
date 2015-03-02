package fr.red.service;

import java.util.List;
import javax.ejb.Local;
import fr.red.entity.Employee;

@Local
public interface EmployeeServiceLocal {
	Employee findById(Employee employee);
	List<Employee> findAll();
}