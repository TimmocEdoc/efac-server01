package com.cafe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static com.cafe.constant.entity.TableName.*;

@Entity
public class ATable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID)
    private Integer id;
    @NotNull
    @Column(name = NAME, length = 50, nullable = false)
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "table")
    @Column(name = ORDER)
    private Set<AOrder> orders;

    public ATable() {
    }

    public ATable(Integer id, String name) {
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

    public Set<AOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<AOrder> orders) {
        this.orders = orders;
    }
}
