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

import fr.mab.model.Room;
import fr.mab.services.RoomServiceLocal;

@Path("room")
@Stateless
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class RoomWebService {

	@EJB
	RoomServiceLocal roomService;

	@GET
	public Response getAllRooms() {
		List<Room> findAll = roomService.findAll();
		return Response.ok(findAll).build();
	}
	
	@POST()
	public Response insertRoom(Room room) {
		roomService.create(room);
		return Response.ok(room).build();
	}
	
	@PUT()
	public Response updateRoom(Room room) {
		roomService.update(room);
		return Response.ok(room).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteRoom(@PathParam("id") Integer id ){
		Room room = new Room();
		room.setIdRoom(id);
		room = roomService.findById(room);
		roomService.delete(room);
		return null;
	}
}