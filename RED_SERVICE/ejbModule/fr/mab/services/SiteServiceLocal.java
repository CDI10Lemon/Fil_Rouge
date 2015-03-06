package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Site;

@Local
public interface SiteServiceLocal {
	Site findById(Site site);
	List<Site> findAll();
	void delete(Site site);
	Site update(Site site);
	Site create(Site site);
}