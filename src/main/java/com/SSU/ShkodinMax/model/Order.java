package com.SSU.ShkodinMax.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staff_id" , nullable = false)
    private Staff staff;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "shipping_date", nullable = false)
    private GregorianCalendar shippingDate;

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "payment_date", nullable = false)
    private GregorianCalendar paymentDate;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ordered> ordered;

    public Order() {

    }

    public Order(Client client, Staff staff,
                 GregorianCalendar shippingDate, GregorianCalendar paymentDate,
                 String address){
        this.client = client;
        this.staff = staff;
        this.shippingDate = shippingDate;
        this.paymentDate = paymentDate;
        this.address = address;
    }


    public int getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOrdered(List<Ordered> ordered) {
        this.ordered = ordered;
    }

    public Client getClient() {
        return client;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setShippingDate(GregorianCalendar shippingDate) {
        this.shippingDate = shippingDate;
    }

    public GregorianCalendar getShippingDate() {
        return shippingDate;
    }

    public void setPaymentDate(GregorianCalendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public GregorianCalendar getPaymentDate() {
        return paymentDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
