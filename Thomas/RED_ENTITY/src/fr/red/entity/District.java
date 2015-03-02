package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "district" database table.
 * 
 */
@Entity
@Table(name="district")
@NamedQuery(name="District.findAll", query="SELECT d FROM District d")
public class District implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_district")
	private int idDistrict;

	@Column(name="name")
	private String name;

	@Column(name="zip")
	private String zip;

	public District() {
	}

	public int getIdDistrict() {
		return this.idDistrict;
	}

	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}