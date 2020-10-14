package com.cafe.service;

import com.cafe.entity.AOrder;
import com.cafe.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.cafe.constant.OrderStatus.*;

@Service
public class OrderService {
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<AOrder> getOrderLists() {
        return orderRepository.findAll();
    }

    public void saveOrder(AOrder order) {
        order.setCreated_at(LocalDateTime.now());
        order.setTotal_price();
        order.setStatus(ACTIVE);
        orderRepository.save(order);
    }

    public void updateOrder(AOrder order) {
        order.setUpdated_at(LocalDateTime.now());
        order.setTotal_price();
        order.setStatus(ACTIVE);
        orderRepository.save(order);
    }
}
