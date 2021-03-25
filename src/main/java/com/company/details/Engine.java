package com.company.details;

public class Engine {
    String manufacturer;
    int power;

    public Engine(String manufacturer, int power) {
        this.manufacturer = manufacturer;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Производитель двигателя: " + this.manufacturer + "\n" +
                "Мощность: " + this.power + "\n";
    }
}
