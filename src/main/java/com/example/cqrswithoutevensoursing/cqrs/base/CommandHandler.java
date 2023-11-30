package com.example.cqrswithoutevensoursing.cqrs.base;

public interface CommandHandler<T extends Command, R> {
    R handle(T command);
}
