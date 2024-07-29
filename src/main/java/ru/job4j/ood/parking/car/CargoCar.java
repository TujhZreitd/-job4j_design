package ru.job4j.ood.parking.car;

public class CargoCar extends Car {

    private static final int SIZE = 1;

    public CargoCar(int size, String name) {
        super(validateSize(size), name);
    }

    private static int validateSize(int size) {
        if (size <= SIZE) {
            throw new IllegalArgumentException("Incorrect size for CargoCar, please enter size more 1");
        }
        return size;
    }
}
