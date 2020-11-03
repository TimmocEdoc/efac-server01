package com.cafe.entity;

import com.cafe.constant.entity.OrderDetailsName;
import com.cafe.constant.entity.OrderName;
import com.cafe.constant.entity.ProductName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.cafe.constant.entity.OrderDetailsName.*;
import static com.cafe.constant.entity.OrderName.*;
import static com.cafe.constant.entity.ProductName.*;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = OrderDetailsName.ID)
    private String orderDetails_id;
    @ManyToOne
    @JoinColumn(name = ProductName.ID)
    private Product product;
    @ManyToOne
    @JoinColumn(name = OrderName.ID)
    private AOrder order;
    @Column(name = QUANTITY)
    private Integer quantity;

    public OrderDetails() {
    }

    public OrderDetails(String orderDetails_id, Product product, AOrder order, Integer quantity) {
        this.orderDetails_id = orderDetails_id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public String getOrderDetails_id() {
        return orderDetails_id;
    }

    public void setOrderDetails_id(String orderDetails_id) {
        this.orderDetails_id = orderDetails_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AOrder getOrder() {
        return order;
    }

    public void setOrder(AOrder order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }
}
