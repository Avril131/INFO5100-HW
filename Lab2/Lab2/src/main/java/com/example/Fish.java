package com.example;

public class Fish extends Animal {
    private String speciesName;
    private int numberOfFins;
    private boolean hasScales;
    private String waterType;
    private int gillCount;
    private boolean canBreatheAir;
    
    public Fish(String typicalSize, double typicalWeight, boolean isPredator, 
                String habitat, int averageLifespan, String dietType, 
                boolean isNocturnal, String reproductionMethod,
                String speciesName, int numberOfFins, boolean hasScales,
                String waterType, int gillCount, boolean canBreatheAir) {
        super(typicalSize, typicalWeight, isPredator, habitat, averageLifespan, 
              dietType, isNocturnal, reproductionMethod);
        this.speciesName = speciesName;
        this.numberOfFins = numberOfFins;
        this.hasScales = hasScales;
        this.waterType = waterType;
        this.gillCount = gillCount;
        this.canBreatheAir = canBreatheAir;
    }
    
    public String getSpeciesName() {
        return speciesName;
    }
    
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    
    public int getNumberOfFins() {
        return numberOfFins;
    }
    
    public void setNumberOfFins(int numberOfFins) {
        this.numberOfFins = numberOfFins;
    }
    
    public boolean hasScales() {
        return hasScales;
    }
    
    public void setHasScales(boolean hasScales) {
        this.hasScales = hasScales;
    }
    
    public String getWaterType() {
        return waterType;
    }
    
    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }
    
    public int getGillCount() {
        return gillCount;
    }
    
    public void setGillCount(int gillCount) {
        this.gillCount = gillCount;
    }
    
    public boolean canBreatheAir() {
        return canBreatheAir;
    }
    
    public void setCanBreatheAir(boolean canBreatheAir) {
        this.canBreatheAir = canBreatheAir;
    }
    
    @Override
    public void makeSound() {
        System.out.println(speciesName + " makes bubbling sounds underwater");
    }
    
    @Override
    public void move() {
        System.out.println(speciesName + " swims using " + numberOfFins + " fins");
    }
    
    @Override
    public void eat() {
        String diet = isPredator() ? "hunts for prey" : "feeds on plants and algae";
        System.out.println(speciesName + " " + diet + " in " + waterType + " water");
    }
    
    public void swim() {
        System.out.println(speciesName + " is swimming in " + waterType + " water");
    }
    
    public void breathe() {
        if (canBreatheAir) {
            System.out.println(speciesName + " can breathe both underwater and in air");
        } else {
            System.out.println(speciesName + " breathes underwater using " + gillCount + " gills");
        }
    }
    
    @Override
    public String toString() {
        return "Fish{" +
                "speciesName='" + speciesName + '\'' +
                ", numberOfFins=" + numberOfFins +
                ", hasScales=" + hasScales +
                ", waterType='" + waterType + '\'' +
                ", gillCount=" + gillCount +
                ", canBreatheAir=" + canBreatheAir +
                "} " + super.toString();
    }
}
