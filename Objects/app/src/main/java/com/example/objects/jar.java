package com.example.objects;

public class jar {

    public jar(double capacity){
        this.isLidOn=true;
        this.fluidLevel = 0;
        if (capacity > 0) {
            this.capacity = capacity;
        }else {
            String message = "Capacity: " + capacity + " is not greater than 0.";
            throw new IllegalArgumentException(message);
        }
    }
    private double capacity;
    public double getCapacity(){
        return capacity;
    }

    private double fluidLevel;
    public double getFluidLevel(){
        return fluidLevel;
    }
    public void setFluidLevel(double fluidLevel){
        if (0 < fluidLevel && fluidLevel <= this.capacity){
            this.fluidLevel = fluidLevel;
        }else{
            String message = "fluidLevel: " + fluidLevel + " is not between 0 and " + this.capacity;
            throw new IllegalArgumentException(message);
        }
    }

    public boolean isLidOn;
    public boolean getLidOn(){
        return isLidOn;
    }
    public void setLidOn(boolean isLidOn){
        this.isLidOn = isLidOn;
    }

}
