package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Structure;

/**
 * Session Bean implementation class PersonneService
 */
@Stateless
public class StructureService implements StructureServiceLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StructureService() {
		
	}

	@Override
	public Structure findById(Structure structure) {
		return entityManager.find(Structure.class, structure.getIdStructure());
	}

	@Override
	public List<Structure> findAll() {
		return entityManager.createNamedQuery("Structure.findAll")
				.getResultList();
	}

	@Override
	public void delete(Structure structure) {
		structure = entityManager.merge(structure);
		entityManager.remove(structure);
	}

	@Override
	public Structure update(Structure structure) {
		return entityManager.merge(structure);
	}

	@Override
	public Structure create(Structure structure) {
		entityManager.persist(structure);
		return structure;
	}



}