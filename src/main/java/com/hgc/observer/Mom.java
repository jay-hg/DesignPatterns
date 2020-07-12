package com.hgc.observer;

public class Mom implements Listener {
    @Override
    public void actionOnWakeup(Event event) {
        feed();
    }

    public void feed() {
        System.out.println("mon feed...");
    }
}
