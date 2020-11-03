package com.cafe.entity;


import com.cafe.constant.entity.ProductName;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.cafe.constant.entity.CategoryName.ID;
import static com.cafe.constant.entity.ProductName.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = ProductName.ID)
    private String id;
    @NotNull
    @Column(name = NAME, length = 50, nullable = false)
    private String name;
    @NotNull
    @Column(name = PRICE, nullable = false)
    private Double price;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = ID)
    private Category category;
    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    @Column(name = ORDERDETAILS)
    private Set<OrderDetails> orderDetails;

    public Product() {
    }

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
