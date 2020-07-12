package com.hgc.observer;

public class Dad implements Listener {
    @Override
    public void actionOnWakeup(Event event) {
        hug();
    }

    public void hug() {
        System.out.println("dad hug...");
    }
}
