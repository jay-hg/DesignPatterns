package com.hgc.strategy;

public class Cat implements Comparable<Cat>{
    private int weight;
    private int height;

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat o) {
        if (this.weight < o.weight) {
            return -1;
        } else if (this.weight > o.weight) {
            return 1;
        }
        return 0;
    }
}
