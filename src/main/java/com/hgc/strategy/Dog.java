package com.hgc.strategy;

public class Dog implements Comparable<Dog> {
    private int weight;

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Dog(int weight) {
        this.weight = weight;
    }

    public int compareTo(Dog o) {
        if (this.weight < o.weight) {
            return -1;
        } else if (this.weight > o.weight) {
            return 1;
        }
        return 0;
    }
}
