package com.cafe.controller;

import com.cafe.dto.OrderForm;
import com.cafe.entity.AOrder;
import com.cafe.entity.ATable;
import com.cafe.entity.OrderDetails;
import com.cafe.service.OrderService;
import com.cafe.service.TableService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/order")
public class OrderController {
    public OrderService orderService;
    public TableService tableService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<AOrder> ListOrder() {
        return orderService.getOrderLists();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<AOrder> CreateOrder(@RequestBody OrderForm orderForm) {
        AOrder order = new AOrder();
        order.setOrderDetails(orderForm.getOrderDetails());
        ATable table = tableService.GetTable(orderForm.getTable_name());
        order.setTable(table);
        orderService.saveOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
