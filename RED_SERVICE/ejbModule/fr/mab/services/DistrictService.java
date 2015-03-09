package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.District;

@Stateless
public class DistrictService implements DistrictServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public DistrictService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public District findById(District district) {
		return entityManager.find(District.class, district.getIdDistrict());
	}

	@Override
	public List<District> findAll() {
		return entityManager.createNamedQuery("District.findAll")
				.getResultList();
	}

	@Override
	public void delete(District district) {
		district = entityManager.merge(district);
		entityManager.remove(district);
	}

	@Override
	public District update(District district) {
		return entityManager.merge(district);
	}

	@Override
	public District create(District district) {
		entityManager.persist(district);
		return district;
	}

}
