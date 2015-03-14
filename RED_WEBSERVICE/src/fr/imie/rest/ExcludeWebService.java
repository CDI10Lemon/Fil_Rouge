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

import fr.mab.model.Exclude;
import fr.mab.services.ExcludeServiceLocal;

@Path("exclude")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ExcludeWebService {

	@EJB
	ExcludeServiceLocal excludeService;

	@GET
	public Response getAllExcludes() {
		List<Exclude> findAll = excludeService.findAll();
		return Response.ok(findAll).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneExclude(@PathParam("id") Integer id){
		Exclude exclude = new Exclude();
		exclude.setIdExclude(id);
		Exclude retour = excludeService.findById(exclude);
		return Response.ok(retour).build();
	}
	
	@POST()
	public Response insertExclude(Exclude exclude) {
		excludeService.create(exclude);
		return Response.ok(exclude).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateExclude(Exclude exclude, @PathParam("id") Integer id) {
		exclude.setIdExclude(id);
		exclude = excludeService.update(exclude);
		return Response.ok(exclude).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteExclude(@PathParam("id") Integer id) {
		Exclude excludeToDelete = new Exclude();
		excludeToDelete.setIdExclude(id);
		excludeService.delete(excludeToDelete);
	}
}