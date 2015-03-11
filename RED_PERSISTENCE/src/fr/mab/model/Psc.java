package fr.mab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "psc" database table.
 * 
 */
@Entity
@Table(name="psc")
@NamedQuery(name="Psc.findAll", query="SELECT p FROM Psc p")
public class Psc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_psc")
	private int idPsc;

	@Column(name="category")
	private String category;

	public Psc() {
	}

	public int getIdPsc() {
		return this.idPsc;
	}

	public void setIdPsc(int idPsc) {
		this.idPsc = idPsc;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}