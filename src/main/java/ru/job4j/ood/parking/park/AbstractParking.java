package ru.job4j.ood.parking.park;

import ru.job4j.ood.parking.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractParking implements Park {
    protected List<Car> parkingForPassenger;
    protected List<Car> parkingForCargo;
    protected int placesForPassenger;
    protected int placesForCargo;

    public AbstractParking(int placesForPassenger, int placesForCargo) {
        this.placesForPassenger = placesForPassenger;
        this.placesForCargo = placesForCargo;
        parkingForPassenger = new ArrayList<>(placesForPassenger);
        parkingForCargo = new ArrayList<>(placesForCargo);
    }

    private int countPlaceForCar(Car car) {
        int result = car.getSize();
        return result;
    }

    private boolean validatePassengerCar(Car car) {
        return car.getSize() == 1;
    }

    @Override
    public boolean add(Car car) {
        boolean result = false;
        if (validatePassengerCar(car)) {
            result = addPassengerCar(car);
        } else {
            result = addCargoCar(car);
        }
        return result;
    }

    private boolean addPassengerCar(Car car) {
        boolean result = false;
        int addSize = countPlaceForCar(car);
        if (placesForPassenger - addSize >= 0) {
            parkingForPassenger.add(car);
            placesForPassenger -= addSize;
            result = true;
        }
        return result;
    }

    private boolean addCargoCar(Car car) {
        boolean result = false;
        int addSize = countPlaceForCar(car);
        if (placesForCargo - addSize >= 0) {
            parkingForCargo.add(car);
            placesForCargo -= addSize;
            result = true;
        } else {
            result = addPassengerCar(car);
        }
        return result;
    }

    @Override
    public boolean delete(Car car) {
        boolean result = false;
        if (validatePassengerCar(car)) {
            result = deletePassengerCar(car);
        } else {
            result = deleteCargoCar(car);
        }
        return result;
    }

    private boolean deletePassengerCar(Car car) {
        boolean result = false;
        int addSize = countPlaceForCar(car);
        if (parkingForPassenger.remove(car)) {
            placesForPassenger += addSize;
            result = true;
        }
        return result;
    }

    private boolean deleteCargoCar(Car car) {
        boolean result = false;
        int addSize = countPlaceForCar(car);
        if (parkingForCargo.remove(car)) {
            placesForCargo += addSize;
            result = true;
        } else {
            result = deletePassengerCar(car);
        }
        return result;
    }

    @Override
    public Car findByName(String name) {
        Car res = null;
        List<Car> allCars = findAll();
        for (Car car : allCars) {
            if (car.getName().equals(name)) {
                res = car;
                break;
            }
        }
        return res;
    }

    @Override
    public List<Car> findAll() {
        List<Car> result = Stream.concat(findAllFromParkingForPassenger().stream(), findAllFromParkingForCargo().stream())
                .toList();
        return result;
    }

    protected List<Car> findAllFromParkingForPassenger() {
        return List.copyOf(parkingForPassenger);
    }

    protected List<Car> findAllFromParkingForCargo() {
        return List.copyOf(parkingForCargo);
    }
}