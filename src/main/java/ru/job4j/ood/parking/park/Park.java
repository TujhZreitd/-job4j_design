package ru.job4j.ood.parking.park;

import ru.job4j.ood.parking.car.Car;

import java.util.List;

public interface Park {
    boolean add(Car car);

    boolean delete(Car car);

    Car findByName(String name);

    List<Car> findAll();

}
