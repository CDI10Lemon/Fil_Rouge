package fr.red.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.red.entity.Exclude;

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

}