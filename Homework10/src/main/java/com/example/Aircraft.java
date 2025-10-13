package com.example;

public class Aircraft extends Vehicle {
    double wingspan;
    double maxAltitude;
    
    public Aircraft(String brand, String model, String year, String color, String price, double maxSpeed, double wingspan, double maxAltitude) {
        super(brand, model, year, color, price, maxSpeed);
        this.wingspan = wingspan;
        this.maxAltitude = maxAltitude;
    }
    
    public void start() { System.out.println("Aircraft engines started"); }
    
    public void stop() { System.out.println("Aircraft engines stopped"); }
    
    public void getVehicleType() { System.out.println("Vehicle Type: Aircraft"); }
    
    public void takeOff() { System.out.println("Aircraft taking off"); }
    
    public void land() { System.out.println("Aircraft landing"); }
    
    public double getWingspan() { return wingspan; }
    
    public void setWingspan(double wingspan) { this.wingspan = wingspan; }
    
    public double getMaxAltitude() { return maxAltitude; }
    
    public void setMaxAltitude(double maxAltitude) { this.maxAltitude = maxAltitude; }
}
