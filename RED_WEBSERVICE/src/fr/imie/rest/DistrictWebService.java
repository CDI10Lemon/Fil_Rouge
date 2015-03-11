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

import fr.mab.model.District;
import fr.mab.services.DistrictServiceLocal;

@Path("district")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class DistrictWebService {

	@EJB
	DistrictServiceLocal districtService;

	@GET
	public Response getAllDistricts() {
		List<District> findAll = districtService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertDistrict(District district) {
		districtService.create(district);
		return Response.ok(district).build();
	}

	@PUT()
	public Response updateEmployee(District district) {
		districtService.update(district);
		return Response.ok(district).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteDistrict(@PathParam("id") Integer id) {
		District district = new District();
		district.setIdDistrict(id);
		district = districtService.findById(district);
		districtService.delete(district);
		return null;
	}
}