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

import fr.mab.model.Structure;
import fr.mab.services.StructureServiceLocal;

@Path("structure")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class StructureWebService {

	@EJB
	StructureServiceLocal structureService;

	@GET
	public Response getAllStructure() {
		List<Structure> findAll = structureService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertStructure(Structure structure) {
		structureService.create(structure);
		return Response.ok(structure).build();
	}

	@PUT()
	public Response updateEmployee(Structure structure) {
		structureService.update(structure);
		return Response.ok(structure).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteStructure(@PathParam("id") Integer id) {
		Structure structure = new Structure();
		structure.setIdStructure(id);
		structure = structureService.findById(structure);
		structureService.delete(structure);
		return null;
	}
}