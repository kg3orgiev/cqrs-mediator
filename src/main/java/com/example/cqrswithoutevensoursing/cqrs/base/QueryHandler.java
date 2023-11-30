package com.example.cqrswithoutevensoursing.cqrs.base;

public interface QueryHandler<T extends Query, R> {
    R handle(T query);
}
