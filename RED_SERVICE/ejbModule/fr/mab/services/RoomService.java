package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Room;

@Stateless
public class RoomService implements RoomServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public RoomService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Room findById(Room room) {
		return entityManager.find(Room.class, room.getIdRoom());
	}

	@Override
	public List<Room> findAll() {
		return entityManager.createNamedQuery("Room.findAll")
				.getResultList();
	}

	@Override
	public void delete(Room room) {
		room = entityManager.merge(room);
		entityManager.remove(room);

	}

	@Override
	public Room update(Room room) {
		return entityManager.merge(room);
	}

	@Override
	public Room create(Room room) {
		entityManager.persist(room);
		return room;
	}

}
