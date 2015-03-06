package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Affectation;

@Stateless
public class AffectationService implements AffectationServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public AffectationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Affectation findById(Affectation affectation) {
		return entityManager.find(Affectation.class, affectation.getIdAffectation());
	}

	@Override
	public List<Affectation> findAll() {
		return entityManager.createNamedQuery("Affectation.findAll")
				.getResultList();
	}

	@Override
	public void delete(Affectation affectation) {
		affectation = entityManager.merge(affectation);
		entityManager.remove(affectation);

	}

	@Override
	public Affectation update(Affectation affectation) {
		return entityManager.merge(affectation);
	}

	@Override
	public Affectation create(Affectation affectation) {
		entityManager.persist(affectation);
		return affectation;
	}

}
