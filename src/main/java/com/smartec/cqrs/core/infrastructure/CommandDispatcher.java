package com.smartec.cqrs.core.infrastructure;

import com.smartec.cqrs.core.commands.BaseCommand;
import com.smartec.cqrs.core.commands.CommandHanlderMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class <T> type, CommandHanlderMethod<T> handler);
    void send(BaseCommand command);
}
