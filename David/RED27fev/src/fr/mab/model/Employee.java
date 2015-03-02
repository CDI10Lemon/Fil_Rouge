package fr.mab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "employee" database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_employee")
	private int idEmployee;

	@Column(name="id_category")
	private int idCategory;

	@Column(name="id_site")
	private int idSite;

	@Column(name="id_site_1")
	private int idSite1;

	@Column(name="id_structure")
	private int idStructure;

	@Column(name="lastname")
	private String lastname;

	@Column(name="name")
	private String name;

	@Column(name="password")
	private String password;

	public Employee() {
	}

	public int getIdEmployee() {
		return this.idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public int getIdSite1() {
		return this.idSite1;
	}

	public void setIdSite1(int idSite1) {
		this.idSite1 = idSite1;
	}

	public int getIdStructure() {
		return this.idStructure;
	}

	public void setIdStructure(int idStructure) {
		this.idStructure = idStructure;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}