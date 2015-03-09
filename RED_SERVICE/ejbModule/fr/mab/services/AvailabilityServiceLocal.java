package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Availability;

@Local
public interface AvailabilityServiceLocal {
	Availability findById(Availability availability);

	List<Availability> findAll();

	void delete(Availability availability);

	Availability update(Availability availability);

	Availability create(Availability availability);
}