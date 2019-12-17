package com.tatsumibruno.performance_jpa.order.application;

import com.tatsumibruno.performance_jpa.order.domain.Order;
import com.tatsumibruno.performance_jpa.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/orders")
public class OrderController {

    @Autowired
    private OrderRepository repository;

    @GetMapping
    public List<Order> getAll() {
        return repository.findAll();
    }
}
