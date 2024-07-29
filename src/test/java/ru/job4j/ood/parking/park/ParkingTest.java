package ru.job4j.ood.parking.park;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.parking.ParkingService;
import ru.job4j.ood.parking.car.Car;
import ru.job4j.ood.parking.car.CargoCar;
import ru.job4j.ood.parking.car.PassengerCar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ParkingTest {
    @Test
    void whenAddCarsWithPassengerAndCargo() {
        Park parking = new Parking(6, 2);
        List<Car> cars = List.of(
                new PassengerCar("BMW"),
                new PassengerCar("Lada"),
                new PassengerCar("Oka"),
                new CargoCar(2, "Volvo"),
                new CargoCar(3, "Kamaz")
        );
        ParkingService parkingService = new ParkingService();
        parkingService.addCars(cars, parking);
        assertTrue(cars.containsAll(parking.findAll()));
    }

    @Test
    void whenAddCarsWithPassengerAndCargo2() {
        Park parking = new Parking(5, 2);
        Car carBmw = new PassengerCar("BMW");
        Car carLada = new PassengerCar("Lada");
        Car carOka = new PassengerCar("Oka");
        Car carVolvo = new CargoCar(2, "Volvo");
        Car carKamaz = new CargoCar(3, "Kamaz");
        List<Car> cars = new ArrayList<>();
        cars.add(carBmw);
        cars.add(carLada);
        cars.add(carOka);
        cars.add(carVolvo);
        cars.add(carKamaz);
        ParkingService parkingService = new ParkingService();
        parkingService.addCars(cars, parking);
        cars.remove(carKamaz);
        assertTrue(cars.containsAll(parking.findAll()));
    }

}