package ru.job4j.ood.parking.car;

public abstract class Car {
    private final int size;
    private final String name;

    public Car(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car {"
                + "name = " + name + ", "
                + "size = " + size
                + '}';
    }
    /*для повторного коммита*/
}
