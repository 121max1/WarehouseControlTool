package com.SSU.ShkodinMax.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Contacts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected int id;

    @Column(name = "full_name", nullable = false)
    protected String fullName;

    @Column(name = "address")
    protected String address;

    @Column(name = "email")
    protected String email;

    @Column(name = "phone_number", nullable = false)
    protected String phoneNumber;

    public Contacts(){

    }

    public Contacts(String fullName, String address, String email,
                    String phoneNumber){
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
