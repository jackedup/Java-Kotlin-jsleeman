package com.example.objects;

public class JellyJar extends DefaultJar{
    public JellyJar(double capacity){
        super(capacity);
    }
    public JellyJar(double capacity, double fluidLevel){
        super(capacity, fluidLevel);
    }
    public JellyJar(double capacity, double fluidLevel, boolean isLidOn){
        super(capacity, fluidLevel, isLidOn);
    }
    public double getJellyLevel(){
        return getFluidLevel();
    }
    public void setJellyLevel(double JellyLevel){
        setFluidLevel(JellyLevel);
    }
    public boolean isSpoiled(){
        return spoiled;
    }
    public void setSpoiled(boolean spoiled){
        this.spoiled = spoiled;
    }

    private boolean spoiled = false;
}
