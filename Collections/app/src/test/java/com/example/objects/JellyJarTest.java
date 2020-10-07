package com.example.objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class JellyJarTest {

    @Test
    public void getJellyLevel() {
        JellyJar instance = new JellyJar(10.0);
        assertEquals(instance.getJellyLevel(), 0.0, 0.0);
    }

    @Test
    public void setJellyLevel() {
        JellyJar instance = new JellyJar(10.0, 8.0);
        assertEquals(instance.getJellyLevel(), 8.0, 0.0);
        instance.setJellyLevel(4.4);
        assertEquals(instance.getJellyLevel(), 4.4, 0.0);

    }

    @Test
    public void getSpoiled() {
        JellyJar instance = new JellyJar(10.0, 8.0, true);
        assertFalse(instance.getSpoiled());
        instance.setSpoiled(true);
        assertTrue(instance.getSpoiled());

    }
}