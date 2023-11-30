package com.example.cqrswithoutevensoursing.entities.order.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private String product;
}
