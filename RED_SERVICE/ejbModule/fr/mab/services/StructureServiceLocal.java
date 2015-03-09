package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Structure;

@Local
public interface StructureServiceLocal {
	Structure findById(Structure structure);
	List<Structure> findAll();
	void delete(Structure structure);
	Structure update(Structure structure);
	Structure create(Structure structure);
}