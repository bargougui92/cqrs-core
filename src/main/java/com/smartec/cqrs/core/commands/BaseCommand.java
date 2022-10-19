package com.smartec.cqrs.core.commands;

import com.smartec.cqrs.core.messages.Message;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class BaseCommand extends Message {

    //maybe no need for this
    BaseCommand(String id) {
        super(id);
    }
}
