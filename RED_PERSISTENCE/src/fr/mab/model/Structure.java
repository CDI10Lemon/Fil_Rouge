package fr.mab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "structure" database table.
 * 
 */
@Entity
@Table(name="structure")
@NamedQuery(name="Structure.findAll", query="SELECT s FROM Structure s")
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_structure")
	private int idStructure;

	@Column(name="name")
	private String name;

	public Structure() {
	}

	public int getIdStructure() {
		return this.idStructure;
	}

	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}