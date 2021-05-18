package me.synology.jstieler.hancockapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    String email;

    String firstname;
    String lastname;

    String salt;
    String password;

    /*
    List<Picture> pictures;
    List<Album> albums;
    List<Like> likes;

     */

    public User() {
    }

    public User(String email, String firstname, String lastname, String salt, String password) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salt = salt;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
