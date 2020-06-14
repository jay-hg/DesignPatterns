package com.hgc.strategy;

import java.util.Comparator;

public class Sort<T> {

    Comparator<T> comparator;

    public Sort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sort(T[] arrs) {
        //冒泡排序
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 1; j < arrs.length - i; j++) {
                if (comparator.compare(arrs[j - 1],arrs[j]) > 0) {
                    swap(arrs, j - 1, j);
                }
            }
        }
    }

    private void swap(T[] arrs, int i, int j) {
        T temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
