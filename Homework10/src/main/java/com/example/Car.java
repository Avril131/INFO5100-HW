package com.example;

public class Car extends Vehicle {
    int numberOfDoors;
    String transmissionType;
    
    public Car(String brand, String model, String year, String color, String price, double maxSpeed, int numberOfDoors, String transmissionType) {
        super(brand, model, year, color, price, maxSpeed);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
    }
    
    public void start() { System.out.println("Car engine started"); }
    
    public void stop() { System.out.println("Car engine stopped"); }
    
    public void getVehicleType() { System.out.println("Vehicle Type: Car"); }
    
    public void honk() { System.out.println("Beep beep!"); }
    
    public int getNumberOfDoors() { return numberOfDoors; }
    
    public void setNumberOfDoors(int numberOfDoors) { this.numberOfDoors = numberOfDoors; }
    
    public String getTransmissionType() { return transmissionType; }
    
    public void setTransmissionType(String transmissionType) { this.transmissionType = transmissionType; }
}
