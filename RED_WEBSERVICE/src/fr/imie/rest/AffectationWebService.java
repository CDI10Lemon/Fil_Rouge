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

import fr.mab.model.Affectation;
import fr.mab.services.AffectationServiceLocal;

@Path("affectation")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AffectationWebService {

	@EJB
	AffectationServiceLocal affectationService;

	@GET
	public Response getAllAffectations() {
		List<Affectation> findAll = affectationService.findAll();
		return Response.ok(findAll).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneAffectation(@PathParam("id") Integer id){
		Affectation affectation = new Affectation();
		affectation.setIdAffectation(id);
		Affectation retour = affectationService.findById(affectation);
		return Response.ok(retour).build();

	}
	
	@POST
	public Response insertAffectation(Affectation affectation) {
		affectationService.create(affectation);
		return Response.ok(affectation).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateAffectation(Affectation affectation, @PathParam("id") Integer id) {
		affectation.setIdAffectation(id);
		affectation = affectationService.update(affectation);
		return Response.ok(affectation).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteAffectation(@PathParam("id") Integer id) {
		Affectation affectationToDelete = new Affectation();
		affectationToDelete.setIdAffectation(id);
		affectationService.delete(affectationToDelete);
	}
}