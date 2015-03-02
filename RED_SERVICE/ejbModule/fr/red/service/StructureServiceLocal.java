package fr.red.service;

import java.util.List;
import javax.ejb.Local;
import fr.red.entity.Employee;
import fr.red.entity.Structure;

@Local
public interface StructureServiceLocal {

	public Employee findPersonById(Employee employee);
	public List<Employee> findEmployeeAll();
	public List<Structure> findAllClass();
	public Structure findStructureById(Structure structure);

}