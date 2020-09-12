package com.example.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class jarTest {

    @Test
    public void getCapacity() {
        double capacity = 12.2;
        jar instance = new jar(capacity);
        assertEquals(capacity, instance.getCapacity(), 0.0);
        jar instance2 = new jar(capacity);
        assertNotEquals(0, instance2.getCapacity(), 0.0);
    }

    @Test
    public void getFluidLevel() {
        double capacity = 12.2;
        jar instance = new jar(capacity);
        assertEquals(instance.getFluidLevel(), 0.0, 0.0);
        instance.setFluidLevel(capacity);
        assertEquals(instance.getFluidLevel(), capacity, 0.0);

    }

    @Test
    public void setFluidLevel() {
        double capacity = 12.2;
        jar instance = new jar(capacity);
        assertEquals(instance.getFluidLevel(), 0, 0.0);
        instance.setFluidLevel(capacity);
        assertEquals(instance.getFluidLevel(), capacity, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadFluidLevel() {
        double capacity = 12.2;
        jar instance = new jar(capacity);
        assertEquals(instance.getFluidLevel(), 0, 0.0);
        instance.setFluidLevel(capacity + 1);
    }

    @Test
    public void getLidOn() {
        jar instance = new jar(10);
        assertTrue(instance.getLidOn());
    }

    @Test
    public void setLidOn() {
        jar instance = new jar(10);
        instance.setLidOn(false);
        assertFalse(instance.getLidOn());
    }
}