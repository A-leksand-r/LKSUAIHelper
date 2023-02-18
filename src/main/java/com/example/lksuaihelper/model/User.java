package com.example.lksuaihelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column(name = "lastname")
    private String lastname;

    //@Column(name = "name")
    private String name;

    //@Column(name = "patronymic")
    private String patronymic;

    //@Column(name = "email")
    private String email;

    //@Column(name = "login")
    private String login;

    //@Column(name = "password")
    private String password;

    public User() {

    }

    public User(String lastname, String name, String patronymic, String email, String login, String password) {
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
