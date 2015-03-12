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

import fr.mab.model.Psc;
import fr.mab.services.PscServiceLocal;

@Path("psc")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class PscWebService {

	@EJB
	PscServiceLocal pscService;

	@GET
	public Response getAllPscs() {
		List<Psc> findAll = pscService.findAll();
		return Response.ok(findAll).build();
	}

	@GET
	@Path("/{id}")
	public Response getOnePsc(@PathParam("id") Integer id){
		Psc psc = new Psc();
		psc.setIdPsc(id);
		Psc retour = pscService.findById(psc);
		return Response.ok(retour).build();
	}
	
	@POST()
	public Response insertPsc(Psc psc) {
		pscService.create(psc);
		return Response.ok(psc).build();
	}

	@PUT
	@Path("/{id}")
	public Response updatePsc(Psc psc, @PathParam("id") Integer id) {
		psc.setIdPsc(id);
		psc = pscService.update(psc);
		return Response.ok(psc).build();
	}

	@DELETE
	@Path("/{id}")
	public void deletePsc(@PathParam("id") Integer id) {
		Psc pscToDelete = new Psc();
		pscToDelete.setIdPsc(id);
		pscService.delete(pscToDelete);
	}
}