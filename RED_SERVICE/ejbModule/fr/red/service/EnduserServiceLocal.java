package fr.red.service;

import java.util.List;
import javax.ejb.Local;
import fr.red.entity.Enduser;

@Local
public interface EnduserServiceLocal {
	Enduser findById(Enduser user);
	List<Enduser> findAll();
}