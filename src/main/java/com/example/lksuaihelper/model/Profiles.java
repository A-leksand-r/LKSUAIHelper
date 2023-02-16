package com.example.lksuaihelper.model;

import jakarta.persistence.*;

@Entity
@Table
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "name")
    private String name;

    private String patronymic;

    @Column(email = "email")
    private String email;

    @Column(login = "login")
    private String login;

    @Column(password = "password")
    private String password;

    public Profiles() {

    }

    public Profiles(String lastname, String name, String patronymic, String email, String login, String password) {
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Profiles [id=" + id + ", lastname=" + lastname + ", name=" + name + ", patronymic="
                + patronymic + ", email=" + email + ", login=" + login + ", password=" + password + "]";
    }
}
