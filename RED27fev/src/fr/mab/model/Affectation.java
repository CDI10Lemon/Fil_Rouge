package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;

/**
 * The persistent class for the "affectation" database table.
 * 
 */
@Entity
@Table(name = "affectation")
@NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a")
public class Affectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_affectation")
	private int idAffectation;

	@Column(name = "end_hour")
	private Time endHour;

	@Column(name = "start_hour")
	private Time startHour;

	@Temporal(TemporalType.DATE)
	@Column(name = "visit_date")
	private Date visitDate;

	@ManyToOne
	@JoinColumn(name = "id_employee")
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "id_unit")
	private Unit unit;

	@ManyToOne
	@JoinColumn(name = "id_enduser")
	private Enduser enduser;

	@ManyToOne
	@JoinColumn(name = "id_visit")
	private Visit visit;

	public Affectation() {
	}

	public int getIdAffectation() {
		return this.idAffectation;
	}

	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}

	public Time getEndHour() {
		return this.endHour;
	}

	public void setEndHour(Time endHour) {
		this.endHour = endHour;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Time getStartHour() {
		return this.startHour;
	}

	public void setStartHour(Time startHour) {
		this.startHour = startHour;
	}

	public Date getVisitDate() {
		return this.visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Enduser getenduser() {
		return this.enduser;
	}

	public void setEnduser(Enduser enduser) {
		this.enduser = enduser;
	}

	public Visit getVisit() {
		return this.visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

}