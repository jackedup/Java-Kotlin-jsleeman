package com.example.objects;

import android.view.ViewDebug;

public class DefaultJar implements Jar, Comparable<DefaultJar>{

    private static double checkCapacity(double capacity){
        if (capacity > 0) {
            return capacity;
        }else {
            String message = "Capacity: " + capacity + " is not greater than 0.";
            throw new IllegalArgumentException(message);
        }
    }
    private double capacity;
    public double getCapacity(){
        return capacity;
    }

    @Override
    public void setCapacity(double depth) {
        this.capacity = checkCapacity(depth);
    }

    private static double checkLevel(double level, double capacity) {
        if (0 > level || level > capacity) {
            String message = "Invalid level  " + level + "." +
                    " Must be positive and must be below capacity";
            throw new IllegalArgumentException(message);
        }
        return level;

    }

    private double fluidLevel;
    public double getFluidLevel(){
        return fluidLevel;
    }
    public void setFluidLevel(double fluidLevel){
        if (0 < fluidLevel && fluidLevel <= this.capacity){
            this.fluidLevel = fluidLevel;
        }else{
            String message = "Invalid Fluid Level";
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

    private String owner = "";

    private String checkOwner(String owner){
       if (owner != null) {
           return owner;
       }else{
           String message = "Invalid owner (null).  Must mot be null.";
           throw new IllegalArgumentException(message);
       }
    }
    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = checkOwner(owner);
    }
    public DefaultJar(double capacity){
        this.capacity = checkCapacity(capacity);
        this.fluidLevel = 0.0;
        this.isLidOn = true;
        this.owner = "";
    }
    public DefaultJar(double capacity, double fluidLevel){
        this.capacity = checkCapacity(capacity);
        this.fluidLevel = checkLevel(fluidLevel, capacity);
        this.isLidOn = true;
        this.owner = "";
    }
    public DefaultJar(double capacity, double fluidLevel, boolean isLidOn){
        this.capacity = checkCapacity(capacity);
        this.fluidLevel = checkLevel(fluidLevel, capacity);
        this.isLidOn = isLidOn;
        this.owner = "";
    }

    //Implementing compareto
    @Override
    public int compareTo(DefaultJar o) {
        int d = Double.compare(this.getFluidLevel(), o.getFluidLevel());
        return d;

    }

}
