package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "site" database table.
 * 
 */
@Entity
@Table(name = "site")
@NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_site")
	private int idSite;

	@Column(name = "max_unit")
	private int maxUnit;

	@Column(name = "name")
	private String name;

	public Site() {
	}

	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public int getMaxUnit() {
		return this.maxUnit;
	}

	public void setMaxUnit(int maxUnit) {
		this.maxUnit = maxUnit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}