package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Psc;

@Local
public interface PscServiceLocal {
	Psc findById(Psc psc);
	List<Psc> findAll();
	void delete(Psc psc);
	Psc update(Psc psc);
	Psc create(Psc psc);
}