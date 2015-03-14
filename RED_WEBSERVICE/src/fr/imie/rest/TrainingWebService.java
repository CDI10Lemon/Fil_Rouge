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

import fr.mab.model.Training;
import fr.mab.services.TrainingServiceLocal;

@Path("training")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class TrainingWebService {

	@EJB
	TrainingServiceLocal trainingService;

	@GET
	public Response getAllTrainings() {
		List<Training> findAll = trainingService.findAll();
		return Response.ok(findAll).build();
	}

	@GET
	@Path("/{id}")
	public Response getOneTraining(@PathParam("id") Integer id){
		Training training = new Training();
		training.setIdTraining(id);
		Training retour = trainingService.findById(training);
		return Response.ok(retour).build();
	}
	
	@POST()
	public Response insertTraining(Training training) {
		trainingService.create(training);
		return Response.ok(training).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateTraining(Training training, @PathParam("id") Integer id) {
		training.setIdTraining(id);
		training = trainingService.update(training);
		return Response.ok(training).build();
	}

	@DELETE
	@Path("/{id}")
	public void deleteTraining(@PathParam("id") Integer id) {
		Training trainingToDelete = new Training();
		trainingToDelete.setIdTraining(id);
		trainingService.delete(trainingToDelete);
	}
}