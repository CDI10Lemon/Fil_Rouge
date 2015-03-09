package fr.mab.services;

import java.util.List;
import javax.ejb.Local;
import fr.mab.model.Category;

@Local
public interface CategoryServiceLocal {
	Category findById(Category category);
	List<Category> findAll();
	void delete(Category category);
	Category update(Category category);
	Category create(Category category);
}