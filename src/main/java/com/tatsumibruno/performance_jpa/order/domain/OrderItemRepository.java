package com.tatsumibruno.performance_jpa.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, UUID> {

    @Override
    @Query("select item from OrderItem item join fetch item.order")
    List<OrderItem> findAll();
}
