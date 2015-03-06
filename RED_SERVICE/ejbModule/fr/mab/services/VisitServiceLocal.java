package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Visit;

@Local
public interface VisitServiceLocal {
	Visit findById(Visit visit);
	List<Visit> findAll();
	void delete(Visit visit);
	Visit update(Visit visit);
	Visit create(Visit visit);
}