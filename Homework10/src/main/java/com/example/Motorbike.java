package com.example;

public class Motorbike extends Vehicle {
    boolean hasSidecar;
    int engineCC;
    
    public Motorbike(String brand, String model, String year, String color, String price, double maxSpeed, boolean hasSidecar, int engineCC) {
        super(brand, model, year, color, price, maxSpeed);
        this.hasSidecar = hasSidecar;
        this.engineCC = engineCC;
    }
    
    public void start() { System.out.println("Motorbike engine started"); }
    
    public void stop() { System.out.println("Motorbike engine stopped"); }
    
    public void getVehicleType() { System.out.println("Vehicle Type: Motorbike"); }
    
    public void wheelie() { System.out.println("Performing wheelie!"); }
    
    public boolean getHasSidecar() { return hasSidecar; }
    
    public void setHasSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }
    
    public int getEngineCC() { return engineCC; }
    
    public void setEngineCC(int engineCC) { this.engineCC = engineCC; }
}
