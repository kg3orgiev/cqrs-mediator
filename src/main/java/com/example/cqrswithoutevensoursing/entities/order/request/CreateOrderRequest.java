package com.example.cqrswithoutevensoursing.entities.order.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderRequest {
    private Long orderId;
    private String product;
}
