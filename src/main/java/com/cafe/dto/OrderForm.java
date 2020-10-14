package com.cafe.dto;

import com.cafe.entity.ATable;
import com.cafe.entity.OrderDetails;

import java.util.Set;

public class OrderForm {
    private Set<OrderDetails> orderDetails;
    private Integer table_name;

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getTable_name() {
        return table_name;
    }

    public void setTable_name(Integer table_name) {
        this.table_name = table_name;
    }
}
