package com.example.objects;

public interface Jar {
    double getCapacity();
    void setCapacity(double depth);

    double getFluidLevel();
    void setFluidLevel(double fluidLevel);

    default boolean isEmpty() { return getFluidLevel() <= 0.0; }

    boolean getLidOn();
    void setLidOn(boolean lidOn);

    String getOwner();
    void setOwner(String owner);
}
