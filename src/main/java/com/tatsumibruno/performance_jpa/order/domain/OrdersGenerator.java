package com.tatsumibruno.performance_jpa.order.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrdersGenerator implements ApplicationRunner {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) {
        jdbcTemplate.update("TRUNCATE ORDERS CASCADE");
        for (int i = 0; i < 3000; i++) {
            Order order = Order.of(String.format("Customer %s", i));
            order.addItem(OrderItem.builder()
                    .order(order)
                    .product(String.format("Product %s", i))
                    .quantity(BigDecimal.ONE)
                    .unitPrice(BigDecimal.valueOf(1.99))
                    .build());
            repository.save(order);
        }
    }
}
