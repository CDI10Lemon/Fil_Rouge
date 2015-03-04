package fr.red.service;

import java.util.List;
import javax.ejb.Local;
import fr.red.entity.Exclude;

@Local
public interface ExcludeServiceLocal {
	Exclude findById(Exclude employee);
	List<Exclude> findAll();
}