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

	@POST()
	public Response insertAffectation(Affectation affectation) {
		affectationService.create(affectation);
		return Response.ok(affectation).build();
	}

	@PUT()
	public Response updateAffectation(Affectation affectation) {
		affectationService.update(affectation);
		return Response.ok(affectation).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteAffectation(@PathParam("id") Integer id) {
		Affectation affectation = new Affectation();
		affectation.setIdAffectation(id);
		affectation = affectationService.findById(affectation);
		affectationService.delete(affectation);
		return null;
	}
}