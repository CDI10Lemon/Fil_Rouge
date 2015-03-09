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

import fr.mab.model.Category;
import fr.mab.services.CategoryServiceLocal;

@Path("category")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class CategoryWebService {

	@EJB
	CategoryServiceLocal categoryService;

	@GET
	public Response getAllCategories() {
		List<Category> findAll = categoryService.findAll();
		return Response.ok(findAll).build();
	}

	@POST()
	public Response insertCategory(Category category) {
		categoryService.create(category);
		return Response.ok(category).build();
	}

	@PUT()
	public Response updateCategory(Category category) {
		categoryService.update(category);
		return Response.ok(category).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCategory(@PathParam("id") Integer id) {
		Category category = new Category();
		category.setIdCategory(id);
		category = categoryService.findById(category);
		categoryService.delete(category);
		return null;
	}
}