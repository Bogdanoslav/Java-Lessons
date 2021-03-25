package com.company;

import com.company.vehicles.Car;
import com.company.details.Engine;
import com.company.professions.Driver;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("Renault", 220);
        Driver driver = new Driver("Zhmishenko Anatoly Pavlovich", 20);
        Car car = new Car("Wolksvagen","S",3,driver, engine);

        car.printInfo();
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
