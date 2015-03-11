package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Unit;

@Local
public interface UnitServiceLocal {
	Unit findById(Unit unit);
	List<Unit> findAll();
	void delete(Unit unit);
	Unit update(Unit unit);
	Unit create(Unit unit);
}