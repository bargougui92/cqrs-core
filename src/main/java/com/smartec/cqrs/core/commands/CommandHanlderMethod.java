package com.smartec.cqrs.core.commands;

@FunctionalInterface
public interface CommandHanlderMethod<T extends BaseCommand> {
    void handle(T command);
}
