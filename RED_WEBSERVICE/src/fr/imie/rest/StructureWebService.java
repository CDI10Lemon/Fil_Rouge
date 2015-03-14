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

	@GET
	@Path("/{id}")
	public Response getOneStructure(@PathParam("id") Integer id){
		Structure structure = new Structure();
		structure.setIdStructure(id);
		Structure retour = structureService.findById(structure);
		return Response.ok(retour).build();
	}
	
	@POST()
	public Response insertStructure(Structure structure) {
		structureService.create(structure);
		return Response.ok(structure).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateStructure(Structure structure, @PathParam("id") Integer id) {
		structure.setIdStructure(id);
		structure = structureService.update(structure);
		return Response.ok(structure).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteStructure(@PathParam("id") Integer id) {
		Structure structureToDelete = new Structure();
		structureToDelete.setIdStructure(id);
		structureService.delete(structureToDelete);
	}
}