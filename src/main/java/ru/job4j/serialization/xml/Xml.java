package ru.job4j.serialization.xml;

public class Xml {
    public static void main(String[] args) {
        Car car = new Car(true,
                2,
                "Chevrolet",
                new Engine(250),
                new String[]{"Automatic transmission", "Climate control"});
    }
}

class Car {
    private final boolean isCabriolet;
    private final int quantityDoors;
    private final String model;
    private final Engine engine;
    private final String[] equipment;

    public Car(boolean isCabriolet, int quantityDoors, String model, Engine engine, String[] equipment) {
        this.isCabriolet = isCabriolet;
        this.quantityDoors = quantityDoors;
        this.model = model;
        this.engine = engine;
        this.equipment = equipment;
    }
}

class Engine {
    private final int motorPower;

    public Engine(int motorPower) {
        this.motorPower = motorPower;
    }
}
