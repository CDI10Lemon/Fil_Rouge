package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.District;

@Local
public interface DistrictServiceLocal {
	District findById(District district);
	List<District> findAll();
	void delete(District district);
	District update(District district);
	District create(District district);
}