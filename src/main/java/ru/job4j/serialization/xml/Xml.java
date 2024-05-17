package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

public class Xml {
    public static void main(String[] args) throws JAXBException {
        Car car = new Car(true,
                2,
                "Chevrolet",
                new Engine(250),
                new String[]{"Automatic transmission", "Climate control"});

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String result = "";

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(car, writer);
            result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(result)) {
            Car res = (Car) unmarshaller.unmarshal(reader);
            System.out.println(res);
        }
    }
}

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
class Car {
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

@XmlRootElement(name = "engine")
class Engine {
    @XmlAttribute
    private int motorPower;

    public Engine() {

    }

    public Engine(int motorPower) {
        this.motorPower = motorPower;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "motorPower=" + motorPower
                + '}';
    }
}
