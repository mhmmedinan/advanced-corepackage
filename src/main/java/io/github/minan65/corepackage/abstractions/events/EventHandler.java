package io.github.minan65.corepackage.abstractions.events;

public interface EventHandler <TEvent>{
    void handle(TEvent event);
}
