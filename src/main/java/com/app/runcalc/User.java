package com.app.runcalc;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @Size(min = 3, max = 20)
    private String firstName;
    @Column(name = "last_name")
    @Size(min = 3, max = 30)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private UserGender userGender;
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @Column(name = "user_img")
    private String userImg;
    private String bio;
    @Column(name = "want_newsletter")
    private boolean wantNewsletter;
    @Email
    private String email;
    @Size(min = 6, max = 50)
    private String password;

    public User() {
    }


    public User(String firstName, String lastName, UserGender userGender, Date birthDate, String userImg, String bio, boolean wantNewsletter, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userGender = userGender;
        this.birthDate = birthDate;
        this.userImg = userImg;
        this.bio = bio;
        this.wantNewsletter = wantNewsletter;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserGender getUserGender() {
        return userGender;
    }

    public void setUserGender(UserGender userGender) {
        this.userGender = userGender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isWantNewsletter() {
        return wantNewsletter;
    }

    public void setWantNewsletter(boolean wantNewsletter) {
        this.wantNewsletter = wantNewsletter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}