package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Availability;

@Stateless
public class AvailabilityService implements AvailabilityServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public AvailabilityService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Availability findById(Availability state) {
		return entityManager.find(Availability.class, state.getIdAvailability());
	}

	@Override
	public List<Availability> findAll() {
		return entityManager.createNamedQuery("Availability.findAll")
				.getResultList();
	}

	@Override
	public void delete(Availability availability) {
		availability = entityManager.merge(availability);
		entityManager.remove(availability);

	}

	@Override
	public Availability update(Availability availability) {
		return entityManager.merge(availability);
	}

	@Override
	public Availability create(Availability availability) {
		entityManager.persist(availability);
		return availability;
	}

}
