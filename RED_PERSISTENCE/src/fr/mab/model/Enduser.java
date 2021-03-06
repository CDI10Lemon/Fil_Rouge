package fr.mab.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the "Enduser" database table.
 * 
 */
@Entity
@Table(name = "Enduser")
@NamedQuery(name = "Enduser.findAll", query = "SELECT u FROM Enduser u")
public class Enduser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enduser")
	private int idEnduser;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;

	@Column(name = "email")
	private String email;

	@Column(name = "name")
	private String name;

	@Column(name = "supported")
	private boolean supported;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_district")
	private District district;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_psc")
	private Psc psc;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_site")
	private Site site;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_training")
	private Training training;

	public Enduser() {
	}

	public int getIdEnduser() {
		return this.idEnduser;
	}

	public void setIdEnduser(int idEnduser) {
		this.idEnduser = idEnduser;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSupported() {
		return this.supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Psc getPsc() {
		return this.psc;
	}

	public void setPsc(Psc psc) {
		this.psc = psc;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}
}