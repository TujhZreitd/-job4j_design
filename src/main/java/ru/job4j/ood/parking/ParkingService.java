package ru.job4j.ood.parking;

import ru.job4j.ood.parking.car.Car;
import ru.job4j.ood.parking.park.Park;
import java.util.List;

public class ParkingService {
    public void addCars(List<Car> cars, Park parking) {
        for (Car car : cars) {
            parking.add(car);
        }
    }

    public void addCar(Car car, Park parking) {
        parking.add(car);
    }
}
/*для повторного коммита*/
