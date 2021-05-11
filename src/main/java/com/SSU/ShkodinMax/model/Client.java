package com.SSU.ShkodinMax.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends Contacts  {

    @Column(name = "note",nullable = true)
    private String note;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Order> ordersList;

    public Client() {

    }

    public Client(String fullName, String address,
                  String phoneNumber, String email,
                  String note) {
        super(fullName,address,email,phoneNumber);
        this.note = note;
    }




    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }


    public void setOrdersList(List<Order> orders) {
        this.ordersList = orders;
    }
   public List<Order> getOrder(){
        return ordersList;
   }
}
