package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the "category" database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private int idCategory;

	@Column(name="name")
	private String name;

	@Column(name="sedentary")
	private boolean sedentary;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSedentary() {
		return this.sedentary;
	}

	public void setSedentary(boolean sedentary) {
		this.sedentary = sedentary;
	}
}