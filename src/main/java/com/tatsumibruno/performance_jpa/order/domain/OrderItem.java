package com.tatsumibruno.performance_jpa.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Builder
@Table(name = "order_items")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderItem {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String product;

    @NotNull
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @NotNull
    private BigDecimal quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "order_item_order_fk"))
    private Order order;

    /* Necessário para evitar problemas de recursividade durante a serialização */
    @JsonIgnore
    public Order getOrder() {
        return order;
    }
}
