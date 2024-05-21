package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Json {
    public static void main(String[] args) {
        Employee employeeFirst = new Employee(true,
                35,
                "Anton",
                new Car1("Nissan", "red"),
                new String[]{"Worker", "Married"});
        Gson gson = new GsonBuilder().create();
        String employeeGson = gson.toJson(employeeFirst);
        System.out.println(employeeGson);
        Employee employeeSecond = gson.fromJson(employeeGson, Employee.class);
        System.out.println(employeeSecond);
    }
}

class Employee {
    private final boolean bestEmployee;
    private final int age;
    private final String name;
    private final Car1 car;
    private final String[] status;

    public Employee(boolean bestEmployee, int age, String name, Car1 car, String[] status) {
        this.bestEmployee = bestEmployee;
        this.age = age;
        this.name = name;
        this.car = car;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "bestEmployee=" + bestEmployee
                + ", age=" + age
                + ", name='" + name
                + '\''
                + ", car=" + car
                + ", status=" + Arrays.toString(status)
                + '}';
    }
}

class Car1 {
    private final String model;
    private final String color;

    public Car1(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model
                + '\''
                + ", color='" + color
                + '\''
                + '}';
    }
}
