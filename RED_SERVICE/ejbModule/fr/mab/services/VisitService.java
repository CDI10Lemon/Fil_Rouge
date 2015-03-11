package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Visit;

@Stateless
public class VisitService implements VisitServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public VisitService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Visit findById(Visit visit) {
		return entityManager.find(Visit.class, visit.getIdVisit());
	}

	@Override
	public List<Visit> findAll() {
		return entityManager.createNamedQuery("Visit.findAll")
				.getResultList();
	}

	@Override
	public void delete(Visit visit) {
		visit = entityManager.merge(visit);
		entityManager.remove(visit);

	}

	@Override
	public Visit update(Visit visit) {
		return entityManager.merge(visit);
	}

	@Override
	public Visit create(Visit visit) {
		entityManager.persist(visit);
		return visit;
	}

}
