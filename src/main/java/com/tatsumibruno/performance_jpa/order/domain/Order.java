package com.tatsumibruno.performance_jpa.order.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Entity
@Table(name = "orders")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private Long number;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    private String customer;

    @Transient
    private List<OrderItem> items = new LinkedList<>();

    public static Order of(String customer) {
        Order order = new Order();
        final long number = new Random().nextLong();
        order.number = number >= 0 ? number : number * -1;
        order.customer = customer;
        return order;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }
}
