package fr.red.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "site" database table.
 * 
 */
@Entity
@Table(name="site")
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_site")
	private int idSite;

	@Column(name="max_unit")
	private int maxUnit;

	@Column(name="name")
	private String name;

	//bi-directional many-to-one association to Room
	@OneToMany(mappedBy="site")
	private List<Room> rooms;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="site")
	private List<User> users;
	
	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="site")
	private List<Employee> employees;
		
	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="site1")
	private List<Employee> employees1;

	public Site() {
	}

	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public int getMaxUnit() {
		return this.maxUnit;
	}

	public void setMaxUnit(int maxUnit) {
		this.maxUnit = maxUnit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setSite(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setSite(null);

		return room;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setSite(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setSite(null);

		return user;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setSite(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setSite(null);

		return employee;
	}

	public List<Employee> getEmployees1() {
		return this.employees1;
	}

	public void setEmployees1(List<Employee> employees1) {
		this.employees1 = employees1;
	}

	public Employee addEmployee1(Employee employee1) {
		getEmployees1().add(employee1);
		employee1.setSite(this);

		return employee1;
	}

	public Employee removeEmployee1(Employee employee1) {
		getEmployees1().remove(employee1);
		employee1.setSite(null);

		return employee1;
	}
	
}