package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;

public class ThirdExampleStore {
    List store = new ArrayList();

    public void addItem(Object o) {
        store.add(o);
    }

    public void printAllItem() {
        store.stream().forEach(System.out::println);
    }
}
