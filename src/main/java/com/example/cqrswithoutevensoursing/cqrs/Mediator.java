package com.example.cqrswithoutevensoursing.cqrs;

import com.example.cqrswithoutevensoursing.cqrs.base.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;

@Service
public class Mediator {
    private final List<CommandHandler<? extends Command, ?>> commandHandlers;
    private final List<QueryHandler<? extends Query, ?>> queryHandlers;

    @Autowired
    public Mediator(List<CommandHandler<? extends Command, ?>> commandHandlers, List<QueryHandler<? extends Query, ?>> queryHandlers) {
        this.commandHandlers = commandHandlers;
        this.queryHandlers = queryHandlers;
    }

    public <R> R send(Request request) {
        if (request instanceof Command) {
            return dispatchCommand((Command) request);
        } else if (request instanceof Query) {
            return dispatchQuery((Query) request);
        } else {
            throw new IllegalArgumentException("Unsupported request type.");
        }
    }

    private <R> R dispatchCommand(Command command) {
        for (var handler : commandHandlers) {
            if(hasHandleMethodWithParameter(handler.getClass(),command.getClass())){
                return ((CommandHandler<Command, R>) handler).handle(command);
            }
        }

        throw new IllegalArgumentException("No command handler found for " + command.getClass());
    }

    private <R> R dispatchQuery(Query query) {
        for (var handler : queryHandlers) {
            if(hasHandleMethodWithParameter(handler.getClass(), query.getClass())){
                return ((QueryHandler<Query, R>) handler).handle(query);
            }
        }
        throw new IllegalArgumentException("No query handler found for " + query.getClass());
    }

    private static boolean hasHandleMethodWithParameter(Class<?> clazz, Class<?> parameterType) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals("handle") && method.getParameterCount() == 1) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes[0] == parameterType) {
                    return true;
                }
            }
        }
        return false;
    }
}
