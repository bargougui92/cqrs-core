package com.smartec.cqrs.core.commands;

import com.smartec.cqrs.core.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseCommand extends Message {

    //maybe no need for this
    BaseCommand(String id) {
        super(id);
    }
}
