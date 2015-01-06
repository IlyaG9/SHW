package ru.shome.web.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Smart Homne Project. ilya.golovachev9@gmail.com
 *
 * @author ILYA_GOLOVACHEV.
 */
public class User implements Serializable {

    private Long id;
    private String firstName;
    private String secondName;
    private Date birthdate;
    private String email;
    private Boolean active;
    private Boolean admin;
    private String password;

    public User(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public User(String firstName, String email, String password) {
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String firstName, String secondName, Date birthdate, String email, Boolean active, Boolean admin, String password) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthdate = birthdate;
        this.email = email;
        this.active = active;
        this.admin = admin;
        this.password = password;
    }

    public User(String firstName, String secondName, Date birthdate, String email, Boolean active, Boolean admin, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthdate = birthdate;
        this.email = email;
        this.active = active;
        this.admin = admin;
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        return ((User) o).getFirstName().equals(firstName) && ((User) o).getPassword().equals(password);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        int hash1 = 97 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        int hash2 = 97 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash += hash1 + hash2;
        return hash;
    }

}