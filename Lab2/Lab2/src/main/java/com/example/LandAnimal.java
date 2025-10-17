package com.example;

public class LandAnimal extends Animal {
    private String speciesName;
    private int numberOfLegs;
    private String furType;
    private boolean hasTail;
    private String locomotionType;
    private int clawCount;
    private boolean isSocial;
    private String territorySize;
    
    public LandAnimal(String typicalSize, double typicalWeight, boolean isPredator, 
                      String habitat, int averageLifespan, String dietType, 
                      boolean isNocturnal, String reproductionMethod,
                      String speciesName, int numberOfLegs, String furType,
                      boolean hasTail, String locomotionType, int clawCount,
                      boolean isSocial, String territorySize) {
        super(typicalSize, typicalWeight, isPredator, habitat, averageLifespan, 
              dietType, isNocturnal, reproductionMethod);
        this.speciesName = speciesName;
        this.numberOfLegs = numberOfLegs;
        this.furType = furType;
        this.hasTail = hasTail;
        this.locomotionType = locomotionType;
        this.clawCount = clawCount;
        this.isSocial = isSocial;
        this.territorySize = territorySize;
    }
    
    public String getSpeciesName() {
        return speciesName;
    }
    
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    
    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
    
    public String getFurType() {
        return furType;
    }
    
    public void setFurType(String furType) {
        this.furType = furType;
    }
    
    public boolean hasTail() {
        return hasTail;
    }
    
    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }
    
    public String getLocomotionType() {
        return locomotionType;
    }
    
    public void setLocomotionType(String locomotionType) {
        this.locomotionType = locomotionType;
    }
    
    public int getClawCount() {
        return clawCount;
    }
    
    public void setClawCount(int clawCount) {
        this.clawCount = clawCount;
    }
    
    public boolean isSocial() {
        return isSocial;
    }
    
    public void setSocial(boolean social) {
        isSocial = social;
    }
    
    public String getTerritorySize() {
        return territorySize;
    }
    
    public void setTerritorySize(String territorySize) {
        this.territorySize = territorySize;
    }
    
    @Override
    public void makeSound() {
        System.out.println(speciesName + " makes characteristic animal sounds");
    }
    
    @Override
    public void move() {
        System.out.println(speciesName + " moves by " + locomotionType + " on " + numberOfLegs + " legs");
    }
    
    @Override
    public void eat() {
        String diet = isPredator() ? "hunts for prey" : "grazes on vegetation";
        System.out.println(speciesName + " " + diet + " in its " + territorySize + " territory");
    }
    
    public void run() {
        System.out.println(speciesName + " runs using " + numberOfLegs + " legs");
    }
    
    public void hunt() {
        if (isPredator()) {
            System.out.println(speciesName + " hunts using " + clawCount + " claws");
        } else {
            System.out.println(speciesName + " does not hunt, it is a herbivore");
        }
    }
    
    public void socialize() {
        if (isSocial) {
            System.out.println(speciesName + " lives in social groups");
        } else {
            System.out.println(speciesName + " is solitary");
        }
    }
    
    public void markTerritory() {
        System.out.println(speciesName + " marks its " + territorySize + " territory");
    }
    
    @Override
    public String toString() {
        return "LandAnimal{" +
                "speciesName='" + speciesName + '\'' +
                ", numberOfLegs=" + numberOfLegs +
                ", furType='" + furType + '\'' +
                ", hasTail=" + hasTail +
                ", locomotionType='" + locomotionType + '\'' +
                ", clawCount=" + clawCount +
                ", isSocial=" + isSocial +
                ", territorySize='" + territorySize + '\'' +
                "} " + super.toString();
    }
}
