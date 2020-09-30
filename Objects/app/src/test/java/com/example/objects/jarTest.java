package com.example.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class jarTest {

    @Test
    public void getCapacity() {
        double capacity = 12.2;
        jar instance = new jar(12.2);
        assertEquals(capacity, instance.getCapacity(), 0.0);
    }

    @Test
    public void getFluidLevel() {
    }

    @Test
    public void setFluidLevel() {
    }

    @Test
    public void getLidOn() {
    }

    @Test
    public void setLidOn() {
    }
}