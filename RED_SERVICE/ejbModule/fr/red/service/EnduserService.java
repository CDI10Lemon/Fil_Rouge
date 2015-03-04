package fr.red.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.red.entity.Enduser;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class EnduserService implements EnduserServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public EnduserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Enduser findById(Enduser enduser) {
		return entityManager.find(Enduser.class, enduser.getIdEnduser());
	}

	@Override
	public List<Enduser> findAll() {
		List<Enduser> resultList = entityManager.createNamedQuery("Enduser.findAll")
				.getResultList();
		return resultList;
	}

}