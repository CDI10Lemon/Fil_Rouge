package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Unit;

@Stateless
public class UnitService implements UnitServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	public UnitService() {

	}

	@Override
	public Unit findById(Unit unit) {
		return entityManager.find(Unit.class, unit.getIdUnit());
	}

	@Override
	public List<Unit> findAll() {
		return entityManager.createNamedQuery("Unit.findAll").getResultList();
	}

	@Override
	public void delete(Unit unit) {
		unit = entityManager.merge(unit);
		entityManager.remove(unit);

	}

	@Override
	public Unit update(Unit unit) {
		return entityManager.merge(unit);
	}

	@Override
	public Unit create(Unit unit) {
		entityManager.persist(unit);
		return unit;
	}
}
