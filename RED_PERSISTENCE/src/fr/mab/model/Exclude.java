package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the "exclude" database table.
 * 
 */
@Entity
@Table(name = "exclude")
@NamedQuery(name = "Exclude.findAll", query = "SELECT e FROM Exclude e")
public class Exclude implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exclude")
	private int idExclude;

	@Temporal(TemporalType.DATE)
	@Column(name = "exclusion_date")
	private Date exclusionDate;

	@Column(name = "status")
	private String status;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_enduser")
	private Enduser enduser;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_employee")
	private Employee employee;

	public Exclude() {
	}

	public int getIdExclude() {
		return this.idExclude;
	}

	public void setIdExclude(int idExclude) {
		this.idExclude = idExclude;
	}

	public Date getExclusionDate() {
		return this.exclusionDate;
	}

	public void setExclusionDate(Date exclusionDate) {
		this.exclusionDate = exclusionDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Enduser getEnduser() {
		return this.enduser;
	}

	public void setEnduser(Enduser enduser) {
		this.enduser = enduser;
	}
}