package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Psc;

@Stateless
public class PscService implements PscServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public PscService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Psc findById(Psc psc) {
		return entityManager.find(Psc.class, psc.getIdPsc());
	}

	@Override
	public List<Psc> findAll() {
		return entityManager.createNamedQuery("Psc.findAll")
				.getResultList();
	}

	@Override
	public void delete(Psc psc) {
		psc = entityManager.merge(psc);
		entityManager.remove(psc);
	}

	@Override
	public Psc update(Psc psc) {
		return entityManager.merge(psc);
	}

	@Override
	public Psc create(Psc psc) {
		entityManager.persist(psc);
		return psc;
	}

}
