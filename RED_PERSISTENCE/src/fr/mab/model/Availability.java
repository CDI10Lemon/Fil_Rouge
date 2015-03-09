package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the "unit" database table.
 * 
 */
@Entity
@Table(name = "availability")
@NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a")
public class Availability implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_availability")
	private int idAvailability;

	@Column(name = "name")
	private String name;

	public Availability() {
	}

	public int getIdAvailability() {
		return this.idAvailability;
	}

	public void setIdAvailability(int idAvailability) {
		this.idAvailability = idAvailability;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}