package com.SSU.ShkodinMax.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToMany
    @JoinTable(name = "provider_product",
            joinColumns = @JoinColumn(name = "provider_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productListAll;

    @OneToMany(mappedBy = "provider",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

    public  Provider(){

    }

    public Provider(String name, String address, String telephoneNumber,String email)
    {
        this.name = name;
        this.address =address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
