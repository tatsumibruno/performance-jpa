package com.tatsumibruno.performance_jpa.order.application;

import com.tatsumibruno.performance_jpa.order.domain.Order;
import com.tatsumibruno.performance_jpa.order.domain.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public List<Order> getAll() {
        return service.findAll();
    }
}
