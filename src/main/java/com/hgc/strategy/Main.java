package com.hgc.strategy;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(1, 1), new Cat(3, 3), new Cat(2, 2)};
        Dog[] dogs = {new Dog(4), new Dog(1), new Dog(8)};
        Sort sort = new Sort(new CatHeightCompator());
        sort.sort(cats);
        for (Cat c : cats) {
            System.out.println(c);
        }

        Sort<Dog> sort2 = new Sort<Dog>((o1, o2) -> {
            if (o1.getWeight() > o2.getWeight()) {
                return -1;
            } else if (o1.getWeight() < o2.getWeight()) {
                return 1;
            } else {
                return 0;
            }
        });
        sort2.sort(dogs);
        for (Dog d : dogs) {
            System.out.println(d);
        }
    }
}
