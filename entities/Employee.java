package com.restdemo.restdemo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "personal_employee_data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mi")
    private char mi;

    @Column(name = "date_joined")
    private java.util.Date dateJoined;

    @Column(name = "email")
    private String email;

    public Employee() {}

    public Employee(String firstName, char mi, String lastName, Date dateJoined, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mi = mi;
        this.dateJoined = dateJoined;
        this.email = email;
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

    public char getMi() {
        return mi;
    }

    public void setMi(char mi) {
        this.mi = mi;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mi=" + mi +
                ", dateJoined=" + dateJoined +
                ", email='" + email + '\'' +
                '}';
    }
}
