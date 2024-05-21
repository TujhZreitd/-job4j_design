package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {
    @XmlAttribute
    private int motorPower;

    public Engine() {

    }

    public Engine(int motorPower) {

        this.motorPower = motorPower;
    }

    public int getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(int motorPower) {
        this.motorPower = motorPower;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "motorPower=" + motorPower
                + '}';
    }
}
