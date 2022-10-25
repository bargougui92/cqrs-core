package com.smartec.cqrs.core.domain;

import com.smartec.cqrs.core.events.BaseEvent;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AggregateRoot {
    protected String id;
    private int version = -1;

    //this list will contain all the changes that are made to the aggregate in the form of events
    private final List<BaseEvent> changes = new ArrayList<>();
    private final Logger logger = Logger.getLogger(AggregateRoot.class.getName());

    public List<BaseEvent> getUncommitedChanges() {
        return this.changes;
    }

    public void markChangesAsCommitted() {
        this.changes.clear();
    }

    protected void applyChange( BaseEvent event, Boolean isNewEvent) {

        try {
            //hethi bech tchouf lclaass li hiya feha w t3ayet lil methode apply if apply doesn't exist there it will raise an exception
            var method = getClass().getDeclaredMethod("apply", event.getClass());
            method.setAccessible(true); //gives access to all the members here even if they are private
            method.invoke(this, event);
        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, MessageFormat.format("the apply method was not found in the aggregate for {0}", event.getClass().getName()));
            throw new RuntimeException(e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error applying event to aggregate", e);
        } finally {
            if (isNewEvent) {
                changes.add(event);
            }
        }
    }

    public void raiseEvent(BaseEvent event){
        applyChange(event, true);
    }

    public void replayEvents(Iterable<BaseEvent> events) {
        events.forEach(event -> applyChange(event, false));
    }

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
