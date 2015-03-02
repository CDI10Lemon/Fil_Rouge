package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "room" database table.
 * 
 */
@Entity
@Table(name="room")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_room")
	private int idRoom;

	@Column(name="number")
	private String number;

	@ManyToOne
	@JoinColumn(name="id_site")
	private Site site;

	@OneToMany(mappedBy="room")
	private List<Unit> units;

	public Room() {
	}

	public int getIdRoom() {
		return this.idRoom;
	}

	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Unit> getUnits() {
		return this.units;
	}

	public void setUnits(List<Unit> units) {
		this.units = units;
	}

	public Unit addUnit(Unit unit) {
		getUnits().add(unit);
		unit.setRoom(this);

		return unit;
	}

	public Unit removeUnit(Unit unit) {
		getUnits().remove(unit);
		unit.setRoom(null);

		return unit;
	}

}