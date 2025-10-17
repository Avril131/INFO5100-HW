package com.example;

public class Bird extends Animal {
    private String speciesName;
    private double wingspan;
    private boolean canFly;
    private String beakType;
    private int numberOfLegs;
    private boolean hasFeathers;
    private String migrationPattern;
    
    public Bird(String typicalSize, double typicalWeight, boolean isPredator, 
                String habitat, int averageLifespan, String dietType, 
                boolean isNocturnal, String reproductionMethod,
                String speciesName, double wingspan, boolean canFly,
                String beakType, int numberOfLegs, boolean hasFeathers,
                String migrationPattern) {
        super(typicalSize, typicalWeight, isPredator, habitat, averageLifespan, 
              dietType, isNocturnal, reproductionMethod);
        this.speciesName = speciesName;
        this.wingspan = wingspan;
        this.canFly = canFly;
        this.beakType = beakType;
        this.numberOfLegs = numberOfLegs;
        this.hasFeathers = hasFeathers;
        this.migrationPattern = migrationPattern;
    }
    
    public String getSpeciesName() {
        return speciesName;
    }
    
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    
    public double getWingspan() {
        return wingspan;
    }
    
    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }
    
    public boolean canFly() {
        return canFly;
    }
    
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
    
    public String getBeakType() {
        return beakType;
    }
    
    public void setBeakType(String beakType) {
        this.beakType = beakType;
    }
    
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
    
    public boolean hasFeathers() {
        return hasFeathers;
    }
    
    public void setHasFeathers(boolean hasFeathers) {
        this.hasFeathers = hasFeathers;
    }
    
    public String getMigrationPattern() {
        return migrationPattern;
    }
    
    public void setMigrationPattern(String migrationPattern) {
        this.migrationPattern = migrationPattern;
    }
    
    @Override
    public void makeSound() {
        System.out.println(speciesName + " chirps and sings");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println(speciesName + " flies with a wingspan of " + wingspan + " meters");
        } else {
            System.out.println(speciesName + " walks on " + numberOfLegs + " legs");
        }
    }
    
    @Override
    public void eat() {
        String diet = isPredator() ? "hunts for prey" : "feeds on seeds and plants";
        System.out.println(speciesName + " " + diet + " using its " + beakType + " beak");
    }
    
    public void fly() {
        if (canFly) {
            System.out.println(speciesName + " is flying with " + wingspan + "m wingspan");
        } else {
            System.out.println(speciesName + " cannot fly");
        }
    }
    
    public void migrate() {
        System.out.println(speciesName + " follows " + migrationPattern + " migration pattern");
    }
    
    public void buildNest() {
        System.out.println(speciesName + " builds a nest for reproduction");
    }
    
    @Override
    public String toString() {
        return "Bird{" +
                "speciesName='" + speciesName + '\'' +
                ", wingspan=" + wingspan +
                ", canFly=" + canFly +
                ", beakType='" + beakType + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                ", hasFeathers=" + hasFeathers +
                ", migrationPattern='" + migrationPattern + '\'' +
                "} " + super.toString();
    }
}
