package com.example;

public class Ship extends Vehicle {
    double tonnage;
    int numberOfDecks;
    
    public Ship(String brand, String model, String year, String color, String price, double maxSpeed, double tonnage, int numberOfDecks) {
        super(brand, model, year, color, price, maxSpeed);
        this.tonnage = tonnage;
        this.numberOfDecks = numberOfDecks;
    }
    
    public void start() { System.out.println("Ship engines started"); }
    
    public void stop() { System.out.println("Ship engines stopped"); }
    
    public void getVehicleType() { System.out.println("Vehicle Type: Ship"); }
    
    public void anchor() { System.out.println("Ship anchored"); }
    
    public void sail() { System.out.println("Ship sailing"); }
    
    public double getTonnage() { return tonnage; }
    
    public void setTonnage(double tonnage) { this.tonnage = tonnage; }
    
    public int getNumberOfDecks() { return numberOfDecks; }
    
    public void setNumberOfDecks(int numberOfDecks) { this.numberOfDecks = numberOfDecks; }
}
