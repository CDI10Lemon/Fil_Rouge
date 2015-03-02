package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "user" database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	@Temporal(TemporalType.DATE)
	@Column(name="birthday")
	private Date birthday;

	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;

	@Column(name="email")
	private String email;

	@Column(name="name")
	private String name;

	@Column(name="supported")
	private boolean supported;

	@Column(name="surname")
	private String surname;

	@Column(name="title")
	private String title;

	@ManyToOne
	@JoinColumn(name="id_district")
	private District district;

	@ManyToOne
	@JoinColumn(name="id_psc")
	private Psc psc;

	@ManyToOne
	@JoinColumn(name="id_site")
	private Site site;

	@ManyToOne
	@JoinColumn(name="id_training")
	private Training training;
	
	@OneToMany(mappedBy="user")
	private List<Affectation> affectations;

	@OneToMany(mappedBy="user")
	private List<Exclude> excludes;

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setUser(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setUser(null);

		return affectation;
	}

	public List<Exclude> getExcludes() {
		return this.excludes;
	}

	public void setExcludes(List<Exclude> excludes) {
		this.excludes = excludes;
	}

	public Exclude addExclude(Exclude exclude) {
		getExcludes().add(exclude);
		exclude.setUser(this);

		return exclude;
	}

	public Exclude removeExclude(Exclude exclude) {
		getExcludes().remove(exclude);
		exclude.setUser(null);

		return exclude;
	}
}