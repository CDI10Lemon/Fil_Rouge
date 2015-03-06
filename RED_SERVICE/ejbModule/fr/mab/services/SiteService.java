package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Site;

@Stateless
public class SiteService implements SiteServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public SiteService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Site findById(Site site) {
		return entityManager.find(Site.class, site.getIdSite());
	}

	@Override
	public List<Site> findAll() {
		return entityManager.createNamedQuery("Site.findAll")
				.getResultList();
	}

	@Override
	public void delete(Site site) {
		site = entityManager.merge(site);
		entityManager.remove(site);

	}

	@Override
	public Site update(Site site) {
		return entityManager.merge(site);
	}

	@Override
	public Site create(Site site) {
		entityManager.persist(site);
		return site;
	}

}
