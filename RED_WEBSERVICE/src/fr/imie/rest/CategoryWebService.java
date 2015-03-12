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
	
	@GET
	@Path("/{id}")
	public Response getOneCategory(@PathParam("id") Integer id){
		Category category = new Category();
		category.setIdCategory(id);
		Category retour = categoryService.findById(category);
		return Response.ok(retour).build();
	}
	
	@POST
	public Response insertCategory(Category category) {
		categoryService.create(category);
		return Response.ok(category).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateCategory(Category category, @PathParam("id") Integer id) {
		category.setIdCategory(id);
		category = categoryService.update(category);
		return Response.ok(category).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteCategory(@PathParam("id") Integer id) {
		Category categoryToDelete = new Category();
		categoryToDelete.setIdCategory(id);
		categoryService.delete(categoryToDelete);
	}
}