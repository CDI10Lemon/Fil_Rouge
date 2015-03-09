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

	@POST()
	public Response insertTraining(Training training) {
		trainingService.create(training);
		return Response.ok(training).build();
	}

	@PUT()
	public Response updateTraining(Training training) {
		trainingService.update(training);
		return Response.ok(training).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteTraining(@PathParam("id") Integer id) {
		Training training = new Training();
		training.setIdTraining(id);
		training = trainingService.findById(training);
		trainingService.delete(training);
		return null;
	}
}