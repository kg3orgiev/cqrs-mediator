package com.example.cqrswithoutevensoursing.entities.order.handlers;

import com.example.cqrswithoutevensoursing.cqrs.base.CommandHandler;
import com.example.cqrswithoutevensoursing.entities.order.commands.CreateOrderCommand;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderCommandHandler implements CommandHandler<CreateOrderCommand, String> {
    @Override
    public String handle(CreateOrderCommand command) {
        return "Order created with ID: " + command.getOrderId();
    }
}
