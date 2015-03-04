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

	@Column(name = "state")
	private String state;

	@ManyToOne
	@JoinColumn(name = "id_room")
	private Room room;

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
}