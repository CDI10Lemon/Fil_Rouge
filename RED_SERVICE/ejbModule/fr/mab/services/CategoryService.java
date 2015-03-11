package fr.mab.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.mab.model.Category;

@Stateless
public class CategoryService implements CategoryServiceLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	public CategoryService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Category findById(Category category) {
		return entityManager.find(Category.class, category.getIdCategory());
	}

	@Override
	public List<Category> findAll() {
		return entityManager.createNamedQuery("Category.findAll")
				.getResultList();
	}

	@Override
	public void delete(Category category) {
		category = entityManager.merge(category);
		entityManager.remove(category);
	}

	@Override
	public Category update(Category category) {
		return entityManager.merge(category);
	}

	@Override
	public Category create(Category category) {
		entityManager.persist(category);
		return category;
	}

}
