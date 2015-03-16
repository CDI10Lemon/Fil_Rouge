package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.mab.model.Employee;
import fr.mab.services.EmployeeServiceLocal;

@Path("employee")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class EmployeeWebService {

	@EJB
	EmployeeServiceLocal employeeService;

	@GET
	public Response getAllEmployees() {
		List<Employee> findAll = employeeService.findAll();
		return Response.ok(findAll).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getOneEmployee(@PathParam("id") Integer id){
		Employee employee = new Employee();
		employee.setIdEmployee(id);
		Employee retour = employeeService.findById(employee);
		return Response.ok(retour).build();

	}

	@POST
	public Response insertEmployee(Employee employee) {
		employee = employeeService.create(employee);
		return Response.ok(employee).build();
	}
	@PUT
	@Path("/{id}")
	public Response updateEmployee(Employee employee, @PathParam("id") Integer id) {
		employee.setIdEmployee(id);
		employee = employeeService.update(employee);
		return Response.ok(employee).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteEmployee(@PathParam("id") Integer id) {
		Employee employeeToDelete = new Employee();
		employeeToDelete.setIdEmployee(id);
		employeeService.delete(employeeToDelete);
	}
}
