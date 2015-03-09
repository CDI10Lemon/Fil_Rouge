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

import fr.mab.model.Enduser;
import fr.mab.services.EnduserServiceLocal;

@Path("enduser")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class EnduserWebService {

	@EJB
	EnduserServiceLocal enduserService;

	@GET
	public Response getAllEndusers() {
		List<Enduser> findAll = enduserService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertEnduser(Enduser enduser) {
		enduserService.create(enduser);
		return Response.ok(enduser).build();
	}

	@PUT()
	public Response updateEnduser(Enduser enduser) {
		enduserService.update(enduser);
		return Response.ok(enduser).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEnduser(@PathParam("id") Integer id) {
		Enduser enduser = new Enduser();
		enduser.setIdEnduser(id);
		enduser = enduserService.findById(enduser);
		enduserService.delete(enduser);
		return null;
	}
}