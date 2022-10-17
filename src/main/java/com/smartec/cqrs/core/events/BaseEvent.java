package com.smartec.cqrs.core.events;

import com.smartec.cqrs.core.messages.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public abstract class BaseEvent extends Message {
    private int version;
}
