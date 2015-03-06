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

import fr.mab.model.Unit;
import fr.mab.services.UnitServiceLocal;

@Path("unit")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class UnitWebService {

	@EJB
	UnitServiceLocal unitService;

	@GET
	public Response getAllUnits() {
		List<Unit> findAll = unitService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertUnit(Unit unit) {
		unitService.create(unit);
		return Response.ok(unit).build();
	}

	@PUT()
	public Response updateUnit(Unit unit) {
		unitService.update(unit);
		return Response.ok(unit).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUnit(@PathParam("id") Integer id) {
		Unit unit = new Unit();
		unit.setIdUnit(id);
		unit = unitService.findById(unit);
		unitService.delete(unit);
		return null;
	}
}