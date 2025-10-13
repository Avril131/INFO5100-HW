package com.example;

public abstract class Vehicle {
    String brand;
    String model;
    String year;
    String color;
    String price;
    double maxSpeed;

    public Vehicle(String brand, String model, String year, String color, String price, double maxSpeed) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public abstract void start();

    public abstract void stop();

    public abstract void getVehicleType();

    public void displayInfo() {
        System.out.println("========== Vehicle Info ==========");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Price: " + price);
        System.out.println("Max Speed: " + maxSpeed);
    }

    public void setBrand(String brand) { this.brand = brand; }

    public void setModel(String model) { this.model = model; }

    public void setYear(String year) { this.year = year; }

    public void setColor(String color) { this.color = color; }

    public void setPrice(String price) { this.price = price; }

    public void setMaxSpeed(double maxSpeed) { this.maxSpeed = maxSpeed; }

    public String getBrand() { return brand; }

    public String getModel() { return model; }

    public String getYear() { return year; }

    public String getColor() { return color; }

    public String getPrice() { return price; }

    public double getMaxSpeed() { return maxSpeed; }

}
