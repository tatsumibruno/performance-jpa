package com.tatsumibruno.performance_jpa.order.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderItemRepository itemRepository;

    public List<Order> findAll() {
        return itemRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(OrderItem::getOrder))
                .entrySet()
                .stream()
                .map(itemsByOrder -> {
                    final List<OrderItem> items = itemsByOrder.getValue();
                    final Order order = itemsByOrder.getKey();
                    items.forEach(order::addItem);
                    return order;
                })
                .collect(Collectors.toList());
    }
}
