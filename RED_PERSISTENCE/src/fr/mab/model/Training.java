package fr.mab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "training" database table.
 * 
 */
@Entity
@Table(name="training")
@NamedQuery(name="Training.findAll", query="SELECT t FROM Training t")
public class Training implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_training")
	private int idTraining;

	@Column(name="name")
	private String name;

	public Training() {
	}

	public int getIdTraining() {
		return this.idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}