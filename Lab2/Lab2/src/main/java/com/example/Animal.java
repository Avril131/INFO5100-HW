package com.example;

public abstract class Animal {
    protected String typicalSize;
    protected double typicalWeight;
    protected boolean isPredator;
    protected String habitat;
    protected int averageLifespan;
    protected String dietType;
    protected boolean isNocturnal;
    protected String reproductionMethod;
    
    public Animal(String typicalSize, double typicalWeight, boolean isPredator, 
                  String habitat, int averageLifespan, String dietType, 
                  boolean isNocturnal, String reproductionMethod) {
        this.typicalSize = typicalSize;
        this.typicalWeight = typicalWeight;
        this.isPredator = isPredator;
        this.habitat = habitat;
        this.averageLifespan = averageLifespan;
        this.dietType = dietType;
        this.isNocturnal = isNocturnal;
        this.reproductionMethod = reproductionMethod;
    }
    
    public String getTypicalSize() {
        return typicalSize;
    }
    
    public void setTypicalSize(String typicalSize) {
        this.typicalSize = typicalSize;
    }
    
    public double getTypicalWeight() {
        return typicalWeight;
    }
    
    public void setTypicalWeight(double typicalWeight) {
        this.typicalWeight = typicalWeight;
    }
    
    public boolean isPredator() {
        return isPredator;
    }
    
    public void setPredator(boolean predator) {
        isPredator = predator;
    }
    
    public String getHabitat() {
        return habitat;
    }
    
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
    
    public int getAverageLifespan() {
        return averageLifespan;
    }
    
    public void setAverageLifespan(int averageLifespan) {
        this.averageLifespan = averageLifespan;
    }
    
    public String getDietType() {
        return dietType;
    }
    
    public void setDietType(String dietType) {
        this.dietType = dietType;
    }
    
    public boolean isNocturnal() {
        return isNocturnal;
    }
    
    public void setNocturnal(boolean nocturnal) {
        isNocturnal = nocturnal;
    }
    
    public String getReproductionMethod() {
        return reproductionMethod;
    }
    
    public void setReproductionMethod(String reproductionMethod) {
        this.reproductionMethod = reproductionMethod;
    }
    
    public abstract void makeSound();
    
    public abstract void move();
    
    public abstract void eat();
    
    public String getPredatorStatus() {
        return isPredator ? "Predator" : "Herbivore";
    }
    
    public String getActivityPattern() {
        return isNocturnal ? "Nocturnal" : "Diurnal";
    }
    
    @Override
    public String toString() {
        return "Animal{" +
                "typicalSize='" + typicalSize + '\'' +
                ", typicalWeight=" + typicalWeight +
                ", isPredator=" + isPredator +
                ", habitat='" + habitat + '\'' +
                ", averageLifespan=" + averageLifespan +
                ", dietType='" + dietType + '\'' +
                ", isNocturnal=" + isNocturnal +
                ", reproductionMethod='" + reproductionMethod + '\'' +
                '}';
    }
}
