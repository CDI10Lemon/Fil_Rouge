package fr.mab.services;

import java.util.List;

import javax.ejb.Local;

import fr.mab.model.Exclude;

@Local
public interface ExcludeServiceLocal {
	Exclude findById(Exclude employee);
	List<Exclude> findAll();
	void delete(Exclude exclude);
	Exclude update(Exclude exclude);
	Exclude create(Exclude exclude);
}