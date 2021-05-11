package com.SSU.ShkodinMax.model;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "staff")
public class Staff extends Contacts {

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "birthday")
    private GregorianCalendar birthday;


    @OneToMany(mappedBy = "staff")
    List<Order> orderList;

    public Staff()
    {

    }
    public Staff(String fullName, String position,
                 GregorianCalendar birthday, String address,
                 String email, String phoneNumber){
        super(fullName,address,email,phoneNumber);
        this.position = position;
        this.birthday = birthday;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setBirthday(GregorianCalendar birthday) {
        this.birthday = birthday;
    }

    public GregorianCalendar getBirthday() {
        return birthday;
    }


    public List<Order> getOrderList() {

        return orderList;
    }

    public void setOrderList(List<Order> orderList) {

        this.orderList = orderList;
    }
}
