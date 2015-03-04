package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "visit" database table.
 * 
 */
@Entity
@Table(name = "visit")
@NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v")
public class Visit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_visit")
	private int idVisit;

	@Column(name = "purpose")
	private String purpose;

	public Visit() {
	}

	public int getIdVisit() {
		return this.idVisit;
	}

	public void setIdVisit(int idVisit) {
		this.idVisit = idVisit;
	}

	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}