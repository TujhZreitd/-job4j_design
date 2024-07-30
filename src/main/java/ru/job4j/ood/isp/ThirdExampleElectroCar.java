package ru.job4j.ood.isp;

interface Car {
    void drive();

    void brake();

    void refuel();
}

public class ThirdExampleElectroCar implements Car {
    @Override
    public void drive() {
        System.out.println("ElectroCar drive");
    }

    @Override
    public void brake() {
        System.out.println("ElectroCar brake");
    }

    @Override
    public void refuel() {
        throw new UnsupportedOperationException();
    }
}
