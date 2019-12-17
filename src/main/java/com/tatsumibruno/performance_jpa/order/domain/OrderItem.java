package com.tatsumibruno.performance_jpa.order.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@Table(name = "order_items")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {
    @Id
    @Getter
    @GeneratedValue
    private UUID id;
    @Getter
    @NotNull
    private String product;
    @Getter
    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @NotNull
    @Getter
    private BigDecimal quantity;
    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_item_order_fk"))
    private Order order;


}
