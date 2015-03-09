package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Training;

@Local
public interface TrainingServiceLocal {
	Training findById(Training training);
	List<Training> findAll();
	void delete(Training training);
	Training update(Training training);
	Training create(Training training);
}