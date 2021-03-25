package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class Car {
    String model;
    String carClass;
    int weight;
    Driver driver;
    Engine engine;

    public Car(String model, String carClass, int weight, Driver driver, Engine engine) {
        this.model = model;
        this.carClass = carClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public void start(){
        System.out.println("Поехали");
    }
    public void stop(){
        System.out.println("Останавливаемся");
    }
    public void turnRight(){
        System.out.println("Поворот направо");
    }
    public void turnLeft(){
        System.out.println("Поворот налево");
    }

    public void printInfo(){
        System.out.println(this.toString() + driver.toString() + engine.toString());
    }

    @Override
    public String toString() {
        return "Модель: " + this.model + "\n" +
                "Класс:" + this.carClass + "\n" +
                "Вес: " + this.weight + "\n";
    }
}
