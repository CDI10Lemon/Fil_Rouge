package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Affectation;

@Local
public interface AffectationServiceLocal {
	Affectation findById(Affectation affectation);
	List<Affectation> findAll();
	void delete(Affectation affectation);
	Affectation update(Affectation affectation);
	Affectation create(Affectation affectation);
}