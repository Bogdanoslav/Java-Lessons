package com.company.professions;

public class Driver {
    String name;
    int experience;

    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Имя водителя: " + this.name + "\n" +
                "Опыт: " + this.experience + "\n";
    }
}
