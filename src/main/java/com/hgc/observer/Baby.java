package com.hgc.observer;

import java.util.ArrayList;
import java.util.List;

public class Baby {
    List<Listener> listenerList = new ArrayList<>();
    public void wakeup() {
        WakeupEvent wakeupEvent = new WakeupEvent(System.currentTimeMillis(), "bed", this);
        for (Listener listener : listenerList) {
            listener.actionOnWakeup(wakeupEvent);
        }
    }

    public void addListener(Listener listener) {
        listenerList.add(listener);
    }

    public void removeListener(Listener listener) {
        listenerList.remove(listener);
    }
}
