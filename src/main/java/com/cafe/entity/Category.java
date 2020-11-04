package com.cafe.entity;

import com.cafe.constant.entity.CategoryName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import static com.cafe.constant.entity.CategoryName.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID)
    private Integer id;
    @NotNull
    @Column(name = NAME, length = 50, nullable = false)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    @Column(name = PRODUCT)
    private Set<Product> products;

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
