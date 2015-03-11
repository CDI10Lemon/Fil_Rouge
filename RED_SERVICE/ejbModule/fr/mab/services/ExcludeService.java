package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Exclude;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class ExcludeService implements ExcludeServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Exclude findById(Exclude exclude) {
		return entityManager.find(Exclude.class, exclude.getIdExclude());
	}

	@Override
	public List<Exclude> findAll() {
		List<Exclude> resultList = entityManager.createNamedQuery("Exclude.findAll")
				.getResultList();
		return resultList;
	}

	@Override
	public void delete(Exclude exclude) {
		exclude = entityManager.merge(exclude);
		entityManager.remove(exclude);	
	}

	@Override
	public Exclude update(Exclude exclude) {
		return entityManager.merge(exclude);
	}

	@Override
	public Exclude create(Exclude exclude) {
		entityManager.persist(exclude);
		return exclude;
	}

}