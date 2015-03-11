package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Training;

@Stateless
public class TrainingService implements TrainingServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public TrainingService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Training findById(Training training) {
		return entityManager.find(Training.class, training.getIdTraining());
	}

	@Override
	public List<Training> findAll() {
		return entityManager.createNamedQuery("Training.findAll")
				.getResultList();
	}

	@Override
	public void delete(Training training) {
		training = entityManager.merge(training);
		entityManager.remove(training);

	}

	@Override
	public Training update(Training training) {
		return entityManager.merge(training);
	}

	@Override
	public Training create(Training training) {
		entityManager.persist(training);
		return training;
	}

}
