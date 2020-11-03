package com.cafe.entity;

import com.cafe.constant.entity.OrderName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.cafe.constant.entity.OrderName.*;
import static com.cafe.constant.entity.OrderName.TOTAL_PRICE;
import static com.cafe.constant.entity.TableName.ID;

@Entity
public class AOrder {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = OrderName.ID)
    private String id;
    @NotNull
    @Column(name = NAME, length = 50, nullable = false)
    private String name;
    @Column(name = CREATED_AT)
    @CreationTimestamp
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime created_at;
    @Column(name = UPDATED_AT)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @UpdateTimestamp
    private LocalDateTime updated_at;
    @Column(name = STATUS)
    private String status;
    @OneToMany(mappedBy = "order")
    @Column(name = ORDERDETAILS)
    private Set<OrderDetails> orderDetails;
    @Column(name = TOTAL_PRICE)
    private Double total_price;
    @ManyToOne
    @JoinColumn(name = ID)
    private ATable table;

    public AOrder() {
    }

    public AOrder(String id, String name, LocalDateTime created_at, LocalDateTime updated_at, String status, Set<OrderDetails> orderDetails, Double total_price) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.status = status;
        this.orderDetails = orderDetails;
        this.total_price = total_price;
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

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price() {
        total_price = 0.0;
        for (OrderDetails o:orderDetails) {
            total_price += o.getTotalPrice();
        }
    }

    public ATable getTable() {
        return table;
    }

    public void setTable(ATable table) {
        this.table = table;
    }
}
