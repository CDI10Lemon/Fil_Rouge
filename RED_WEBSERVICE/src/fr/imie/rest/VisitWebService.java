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

import fr.mab.model.Visit;
import fr.mab.services.VisitServiceLocal;

@Path("visit")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class VisitWebService {

	@EJB
	VisitServiceLocal visitService;

	@GET
	public Response getAllVisits() {
		List<Visit> findAll = visitService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertVisit(Visit visit) {
		visitService.create(visit);
		return Response.ok(visit).build();
	}

	@PUT()
	public Response updateVisit(Visit visit) {
		visitService.update(visit);
		return Response.ok(visit).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteEmployee(@PathParam("id") Integer id) {
		Visit visit = new Visit();
		visit.setIdVisit(id);
		visit = visitService.findById(visit);
		visitService.delete(visit);
		return null;
	}
}