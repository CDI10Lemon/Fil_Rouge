package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Room;

@Local
public interface RoomServiceLocal {
	Room findById(Room room);
	List<Room> findAll();
	void delete(Room room);
	Room update(Room room);
	Room create(Room room);
}