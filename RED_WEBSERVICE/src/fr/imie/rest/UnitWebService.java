package fr.imie.rest;

import java.util.ArrayList;
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
	
	@GET
	@Path("/{id}")
	public Response getOneUnit(@PathParam("id") Integer id){
		Unit unit = new Unit();
		unit.setIdUnit(id);
		Unit retour = unitService.findById(unit);
		return Response.ok(retour).build();

	}
	
	@GET
	@Path("/idroom/{id}")
	public Response getAllUnitsByIdSite(@PathParam("id") Integer id ) {
		List<Unit> findAll = unitService.findAll();
		List<Unit> findByIdRoom = new ArrayList<Unit>();
		
		for (Unit item : findAll) {
		    if ((item.getRoom().getIdRoom()) == (id)){
		    	findByIdRoom.add(item);
		    }
		} 
		return Response.ok(findByIdRoom).build();
	}
	
	@POST()
	public Response insertUnit(Unit unit) {
		unitService.create(unit);
		return Response.ok(unit).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateUnit(Unit unit, @PathParam("id") Integer id) {
		unit.setIdUnit(id);
		unit = unitService.update(unit);
		return Response.ok(unit).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteUnit(@PathParam("id") Integer id) {
		Unit unitToDelete = new Unit();
		unitToDelete.setIdUnit(id);
		unitService.delete(unitToDelete);
	}
}