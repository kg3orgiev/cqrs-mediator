package com.example.cqrswithoutevensoursing.entities.order.handlers;

import com.example.cqrswithoutevensoursing.cqrs.base.QueryHandler;
import com.example.cqrswithoutevensoursing.entities.order.dtos.OrderDto;
import com.example.cqrswithoutevensoursing.entities.order.query.GetOrderQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderQueryHandler implements QueryHandler<GetOrderQuery, List<OrderDto>> {
    @Override
    public List<OrderDto> handle(GetOrderQuery query) {
        var order = new OrderDto();
        order.setOrderId(1L);
        order.setProduct("Dummy Product");

        var order1 = new OrderDto();
        order1.setOrderId(2L);
        order1.setProduct("Dummy Product 2");

        return List.of(order,order1);
    }
}
