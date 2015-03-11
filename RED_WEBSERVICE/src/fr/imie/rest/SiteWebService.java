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

import fr.mab.model.Site;
import fr.mab.services.SiteServiceLocal;

@Path("site")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class SiteWebService {

	@EJB
	SiteServiceLocal siteService;

	@GET
	public Response getAllSites() {
		List<Site> findAll = siteService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertSite(Site site) {
		siteService.create(site);
		return Response.ok(site).build();
	}

	@PUT()
	public Response updateSite(Site site) {
		siteService.update(site);
		return Response.ok(site).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteSite(@PathParam("id") Integer id) {
		Site site = new Site();
		site.setIdSite(id);
		site = siteService.findById(site);
		siteService.delete(site);
		return null;
	}
}