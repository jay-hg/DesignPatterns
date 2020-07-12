package com.hgc.observer;

public class Main {
    public static void main(String[] args) {
        Baby baby = new Baby();
        Dad dad = new Dad();
        baby.addListener(dad);
        baby.addListener(new Mom());
        baby.wakeup();

        baby.removeListener(dad);
        baby.wakeup();
    }
}
