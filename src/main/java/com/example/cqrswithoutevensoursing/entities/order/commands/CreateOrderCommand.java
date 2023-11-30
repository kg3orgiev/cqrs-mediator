package com.example.cqrswithoutevensoursing.entities.order.commands;

import com.example.cqrswithoutevensoursing.cqrs.base.Command;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CreateOrderCommand implements Command {
    private Long orderId;
    private String product;

    public CreateOrderCommand(Long orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }
}
