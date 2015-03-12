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

import fr.mab.model.Availability;
import fr.mab.services.AvailabilityServiceLocal;

@Path("availability")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AvailabilityWebService {

	@EJB
	AvailabilityServiceLocal availabilityService;

	@GET
	public Response getAllAvailabilities() {
		List<Availability> findAll = availabilityService.findAll();
		return Response.ok(findAll).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getOneAvailability(@PathParam("id") Integer id){
		Availability availability = new Availability();
		availability.setIdAvailability(id);
		Availability retour = availabilityService.findById(availability);
		return Response.ok(retour).build();
	}
	
	@POST
	public Response insertAvailability(Availability availability) {
		availabilityService.create(availability);
		return Response.ok(availability).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateAvailability(Availability availability, @PathParam("id") Integer id) {
		availability.setIdAvailability(id);
		availability = availabilityService.update(availability);
		return Response.ok(availability).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteAvailability(@PathParam("id") Integer id) {
		Availability availabilityToDelete = new Availability();
		availabilityToDelete.setIdAvailability(id);
		availabilityService.delete(availabilityToDelete);
	}
}