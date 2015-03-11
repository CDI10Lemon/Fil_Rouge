package fr.mab.services;

import java.util.List;

import javax.ejb.Local;

import fr.mab.model.Enduser;

@Local
public interface EnduserServiceLocal {
	Enduser findById(Enduser enduser);
	List<Enduser> findAll();
	void delete(Enduser enduser);
	Enduser update(Enduser enduser);
	Enduser create(Enduser enduser);
}