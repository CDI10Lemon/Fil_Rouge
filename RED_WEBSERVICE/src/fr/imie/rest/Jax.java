package fr.imie.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.mab.model.Employee;
import fr.mab.services.EmployeeServiceLocal;

@Path("jax")
@Produces({ "application/json" })
public class Jax {

	@EJB
	EmployeeServiceLocal employeeService;

	@GET
	
	public Response getRest() {

		List<Employee> findAll = employeeService.findAll();
				
		return Response.ok(findAll).build();
		

	}
	
	@POST()
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response meth(Employee employee) {
		employeeService.create(employee);
		return Response.ok(employee).build();
		

	}
	
	@PUT()
	@Consumes({ "application/json" })
	@Produces({ "application/json" })	
	public Response methUP(Employee employee) {
		
		
		employeeService.update(employee);
		return Response.ok(employee).build();
		

	}
	
	
	
	
	@DELETE
	@Path("/{id}")
	public Response meth(@PathParam("id") Integer id ) 
	{
		Employee employee = new Employee();
		employee.setIdEmployee(id);
		employee=employeeService.findById(employee);
		employeeService.delete(employee);
		return null;
	}
	

}
