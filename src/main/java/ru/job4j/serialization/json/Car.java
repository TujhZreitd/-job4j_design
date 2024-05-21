package ru.job4j.serialization.json;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class Car {
    @XmlAttribute
    private boolean isCabriolet;
    @XmlAttribute
    private int quantityDoors;
    private String model;
    private Engine engine;
    @XmlElementWrapper(name = "equipments")
    @XmlElement(name = "equipment")
    private String[] equipment;

    public Car() {

    }

    public Car(boolean isCabriolet, int quantityDoors, String model, Engine engine, String[] equipment) {
        this.isCabriolet = isCabriolet;
        this.quantityDoors = quantityDoors;
        this.model = model;
        this.engine = engine;
        this.equipment = equipment;
    }

    public boolean isCabriolet() {
        return isCabriolet;
    }

    public void setCabriolet(boolean cabriolet) {
        isCabriolet = cabriolet;
    }

    public int getQuantityDoors() {
        return quantityDoors;
    }

    public void setQuantityDoors(int quantityDoors) {
        this.quantityDoors = quantityDoors;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String[] getEquipment() {
        return equipment;
    }

    public void setEquipment(String[] equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Car{"
                + "isCabriolet=" + isCabriolet
                + ", quantityDoors=" + quantityDoors
                + ", model='" + model
                + '\''
                + ", engine=" + engine
                + ", equipment="
                + Arrays.toString(equipment)
                + '}';
    }
}
