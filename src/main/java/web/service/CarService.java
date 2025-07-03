package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarService {

private final List<Car> cars;


    public CarService() {
        cars = new ArrayList<Car>();
        cars.add(new Car("BMW", "white", 2020));
        cars.add(new Car("Lada", "red", 2022));
        cars.add(new Car("Toyota", "white", 2018));
        cars.add(new Car("Volkswagen", "blue", 2024));
        cars.add(new Car("Mercedes", "green", 2025));
    }

    public List<Car> getCars(int count) {
        if (count <= 0) {
            return Collections.emptyList();
        }
        if (count >= cars.size()) {
            return new ArrayList<>(cars);
        }
        return cars.subList(0, count);
    }
}
