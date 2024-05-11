package com.adsima.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntity(EntityEvent entityEvent) {
        System.out.printf("Entity: " + entityEvent);
    }
}
