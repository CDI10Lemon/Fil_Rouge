package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Enduser;

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

	@Override
	public void delete(Enduser enduser) {
		enduser = entityManager.merge(enduser);
		entityManager.remove(enduser);
		
	}

	@Override
	public Enduser update(Enduser enduser) {
		return entityManager.merge(enduser);
	}

	@Override
	public Enduser create(Enduser enduser) {
		entityManager.persist(enduser);
		return enduser;
	}

}