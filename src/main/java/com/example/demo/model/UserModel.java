package com.example.demo.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserModel {
    @Size(min = 4, max = 30)
    @NotEmpty(message = "{name.notemty}")
    String name;
    @Size(max = 50)
    @NotEmpty(message = "{surname.notemty}")
    String surname;
    @Email
    @NotEmpty(message = "{email.notempty}")
    String email;

    public UserModel() {
    }

    public UserModel(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
