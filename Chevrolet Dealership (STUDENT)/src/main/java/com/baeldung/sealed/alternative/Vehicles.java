package com.baeldung.sealed.alternative;

public interface Drivable {
    void drive();
}

abstract class Vehicle {
    private final String registrationNumber;

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

public class Car extends Vehicle implements Drivable {
    private final int numberOfSeats;

    public Car(int numberOfSeats, String registrationNumber) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public void drive() {
        System.out.println("Driving the car with registration number: " + getRegistrationNumber());
    }
}

public class Truck extends Vehicle implements Drivable {
    private final int loadCapacity;

    public Truck(int loadCapacity, String registrationNumber) {
        super(registrationNumber);
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void drive() {
        System.out.println("Driving the truck with registration number: " + getRegistrationNumber());
    }
}

