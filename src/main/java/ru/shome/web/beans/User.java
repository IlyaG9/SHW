package ru.shome.web.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Smart Home Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
/**
 * @author ILYA
 *
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "first_name")
	@Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Must be alphabet with no space")
	private String firstName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "birthdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthdate;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "admin")
	private Boolean admin;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "login",unique = true)
	private String login;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<UserGroup> userGroups;
	
	public User() {
		super();
	}

	public User(String firstName, String password) {
		this.firstName = firstName;
		this.password = password;
	}

	public User(String firstName, String email, String password) {
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public User(Long id, String firstName, String secondName, Date birthdate,
			String email, Boolean active, Boolean admin, String password) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthdate = birthdate;
		this.email = email;
		this.active = active;
		this.admin = admin;
		this.password = password;
	}

	public User(String firstName, String secondName, Date birthdate,
			String email, Boolean active, Boolean admin, String password) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthdate = birthdate;
		this.email = email;
		this.active = active;
		this.admin = admin;
		this.password = password;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getActive() {
		return active;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<UserGroup> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}

	@Override
	public boolean equals(Object o) {
		return ((User) o).getFirstName().equals(firstName)
				&& ((User) o).getPassword().equals(password);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		int hash1 = 97 * hash
				+ (this.firstName != null ? this.firstName.hashCode() : 0);
		int hash2 = 97 * hash
				+ (this.password != null ? this.password.hashCode() : 0);
		hash += hash1 + hash2;
		return hash;
	}

}
