package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the "unit" database table.
 * 
 */
@Entity
@Table(name = "unit")
@NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u")
public class Unit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unit")
	private int idUnit;

	@Column(name = "number")
	private String number;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_room")
	private Room room;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_availability")
	private Availability availability;

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

	public Availability getAvailability() {
		return this.availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}