package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Vehicle Management System ===");
        
        while (true) {
            System.out.println();
            System.out.println("Menu options:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. List all vehicles");
            System.out.println("3. Find fastest vehicle");
            System.out.println("4. Search by type");
            System.out.println("5. Remove a vehicle");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    listAllVehicles();
                    break;
                case 3:
                    findFastestVehicle();
                    break;
                case 4:
                    searchByType();
                    break;
                case 5:
                    removeVehicle();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void addVehicle() {
        System.out.println("=== Add Vehicle ===");
        System.out.print("Enter vehicle type (car/motorbike/aircraft/ship): ");
        String type = scanner.nextLine().toLowerCase();
        
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        String year = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter price: ");
        String price = scanner.nextLine();
        System.out.print("Enter max speed: ");
        double maxSpeed = scanner.nextDouble();
        scanner.nextLine();
        
        Vehicle vehicle = null;
        
        switch (type) {
            case "car":
                System.out.print("Enter number of doors: ");
                int doors = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter transmission type (automatic/manual): ");
                String transmission = scanner.nextLine();
                vehicle = new Car(brand, model, year, color, price, maxSpeed, doors, transmission);
                break;
            case "motorbike":
                System.out.print("Has sidecar? (true/false): ");
                boolean sidecar = scanner.nextBoolean();
                scanner.nextLine();
                System.out.print("Enter engine CC: ");
                int cc = scanner.nextInt();
                scanner.nextLine();
                vehicle = new Motorbike(brand, model, year, color, price, maxSpeed, sidecar, cc);
                break;
            case "aircraft":
                System.out.print("Enter wingspan: ");
                double wingspan = scanner.nextDouble();
                System.out.print("Enter max altitude: ");
                double altitude = scanner.nextDouble();
                scanner.nextLine();
                vehicle = new Aircraft(brand, model, year, color, price, maxSpeed, wingspan, altitude);
                break;
            case "ship":
                System.out.print("Enter tonnage: ");
                double tonnage = scanner.nextDouble();
                System.out.print("Enter number of decks: ");
                int decks = scanner.nextInt();
                scanner.nextLine();
                vehicle = new Ship(brand, model, year, color, price, maxSpeed, tonnage, decks);
                break;
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }
        
        vehicles.add(vehicle);
        System.out.println("[success]: Vehicle added!");
    }
    
    private static void listAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found!");
            return;
        }
        
        System.out.println("=== All Vehicles ===");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getClass().getSimpleName());
            vehicles.get(i).displayInfo();
            System.out.println();
        }
    }
    
    private static void findFastestVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found!");
            return;
        }
        
        Vehicle fastest = vehicles.get(0);
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMaxSpeed() > fastest.getMaxSpeed()) {
                fastest = vehicle;
            }
        }
        
        System.out.println("=== Fastest Vehicle ===");
        System.out.println("Type: " + fastest.getClass().getSimpleName());
        fastest.displayInfo();
    }
    
    private static void searchByType() {
        System.out.print("Enter vehicle type to search (car/motorbike/aircraft/ship): ");
        String type = scanner.nextLine().toLowerCase();
        
        List<Vehicle> found = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getClass().getSimpleName().toLowerCase().equals(type)) {
                found.add(vehicle);
            }
        }
        
        if (found.isEmpty()) {
            System.out.println("No " + type + " vehicles found!");
        } else {
            System.out.println("=== " + type.toUpperCase() + " Vehicles ===");
            for (int i = 0; i < found.size(); i++) {
                System.out.println((i + 1) + ". " + found.get(i).getClass().getSimpleName());
                found.get(i).displayInfo();
                System.out.println();
            }
        }
    }
    
    private static void removeVehicle() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles to remove!");
            return;
        }
        
        System.out.println("=== Remove Vehicle ===");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println((i + 1) + ". " + vehicles.get(i).getClass().getSimpleName() + " - " + vehicles.get(i).getBrand() + " " + vehicles.get(i).getModel());
        }
        
        System.out.print("Enter vehicle number to remove: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index >= 0 && index < vehicles.size()) {
            Vehicle removed = vehicles.remove(index);
            System.out.println("[success]: " + removed.getClass().getSimpleName() + " removed!");
        } else {
            System.out.println("Invalid vehicle number!");
        }
    }
}
