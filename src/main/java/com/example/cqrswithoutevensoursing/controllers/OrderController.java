package com.example.cqrswithoutevensoursing.controllers;

import com.example.cqrswithoutevensoursing.cqrs.Mediator;
import com.example.cqrswithoutevensoursing.entities.order.commands.CreateOrderCommand;
import com.example.cqrswithoutevensoursing.entities.order.dtos.OrderDto;
import com.example.cqrswithoutevensoursing.entities.order.query.GetOrderQuery;
import com.example.cqrswithoutevensoursing.entities.order.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/orders")
public class OrderController {
    private final Mediator mediator;

    @Autowired
    public OrderController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderRequest request) {
        String result = mediator.send(CreateOrderCommand
                .builder()
                .orderId(request.getOrderId())
                .product(request.getProduct())
                .build());

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll(){
        List<OrderDto> orders1 = mediator.send(new GetOrderQuery());
        var orders = mediator.<List<OrderDto>>send(new GetOrderQuery());

        return ResponseEntity.ok(orders);
    }
}
