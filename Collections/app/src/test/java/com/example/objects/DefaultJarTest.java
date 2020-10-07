package com.example.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultJarTest {

    @Test
    public void getCapacity() {
        double capacity = 12.2;
        DefaultJar instance = new DefaultJar(capacity);
        assertEquals(capacity, instance.getCapacity(), 0.0);
        DefaultJar instance2 = new DefaultJar(capacity);
        assertNotEquals(0, instance2.getCapacity(), 0.0);
    }

    @Test
    public void getFluidLevel() {
        double capacity = 12.2;
        DefaultJar instance = new DefaultJar(capacity);
        assertEquals(instance.getFluidLevel(), 0.0, 0.0);
        instance.setFluidLevel(capacity);
        assertEquals(instance.getFluidLevel(), capacity, 0.0);

    }

    @Test
    public void setFluidLevel() {
        double capacity = 12.2;
        DefaultJar instance = new DefaultJar(capacity);
        assertEquals(instance.getFluidLevel(), 0, 0.0);
        instance.setFluidLevel(capacity);
        assertEquals(instance.getFluidLevel(), capacity, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadFluidLevel() {
        double capacity = 12.2;
        DefaultJar instance = new DefaultJar(capacity);
        assertEquals(instance.getFluidLevel(), 0, 0.0);
        instance.setFluidLevel(capacity + 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setBadFluidLevelConst() {
        double capacity = 10.0;
        DefaultJar instance = new DefaultJar(capacity, capacity + 1);
    }


    @Test
    public void getLidOn() {
        DefaultJar instance = new DefaultJar(10);
        assertTrue(instance.getLidOn());
        instance = new DefaultJar(10.0, 8.0, false);
        assertFalse(instance.getLidOn());
    }

    @Test
    public void setLidOn() {
        DefaultJar instance = new DefaultJar(10);
        instance.setLidOn(false);
        assertFalse(instance.getLidOn());
        instance = new DefaultJar(10.0);
        assertTrue(instance.getLidOn());
    }

    @Test
    public void setCapacity() {
        DefaultJar instance = new DefaultJar(10.0);
        instance.setCapacity(30.0);
        assertEquals(instance.getCapacity(), 30.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBadCapacity() {
        DefaultJar instance = new DefaultJar(-10.0);
    }

    @Test
    public void isEmpty() {
        DefaultJar instance = new DefaultJar(10.0, 0.0);
        assertTrue(instance.isEmpty());
        instance.setFluidLevel(1.0);
        assertFalse(instance.isEmpty());
    }

    @Test
    public void getSetOwner() {
        DefaultJar instance = new DefaultJar(10.0);
        instance.setOwner("me");
        assertEquals("me", instance.getOwner());
    }
    @Test(expected = IllegalArgumentException.class)
    public void setBadOwner() {
        DefaultJar instance = new DefaultJar(10.0);
        instance.setOwner(null);
    }
    //test is relatively comprehensive to prove the workaround for compareto works
    @Test
    public void compareTo(){
        DefaultJar instance = new DefaultJar(10.0, 5.0);
        DefaultJar instance2 = new DefaultJar(10.0, 5.2);
        DefaultJar instance3 = new DefaultJar(10.0, 5.4);
        DefaultJar instance4 = new DefaultJar(10.0, 5.4);
        DefaultJar instance5 = new DefaultJar(10.0, 5.6);

        assertTrue(instance.compareTo(instance2) < 0);
        assertTrue(instance2.compareTo(instance) > 0);
        assertTrue(instance3.compareTo(instance4) == 0);
        assertTrue(instance.compareTo(instance5) < 0);
    }
}