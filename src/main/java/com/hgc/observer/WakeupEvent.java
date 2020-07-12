package com.hgc.observer;

public class WakeupEvent extends Event<Baby> {

    long timestamp;
    String location;
    Baby source;

    public WakeupEvent(long timestamp, String location, Baby source) {
        this.timestamp = timestamp;
        this.location = location;
        this.source = source;
    }

    @Override
    Baby getSource() {
        return this.source;
    }
}
