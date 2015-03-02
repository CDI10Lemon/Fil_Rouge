package fr.red.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "unit" database table.
 * 
 */
@Entity
@Table(name="unit")
@NamedQuery(name="Unit.findAll", query="SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unit")
	private int idUnit;

	@Column(name="number")
	private String number;

	@Column(name="state")
	private String state;

	@ManyToOne
	@JoinColumn(name="id_room")
	private Room room;
	
	@OneToMany(mappedBy="unit")
	private List<Affectation> affectations;
		
	public Unit() {
	}

	public int getIdUnit() {
		return this.idUnit;
	}

	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setUnit(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setUnit(null);

		return affectation;
	}
}