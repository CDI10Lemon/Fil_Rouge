package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "room" database table.
 * 
 */
@Entity
@Table(name = "room")
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_room")
	private int idRoom;

	@Column(name = "number")
	private String number;

	@ManyToOne
	@JoinColumn(name = "id_site")
	private Site site;

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
}