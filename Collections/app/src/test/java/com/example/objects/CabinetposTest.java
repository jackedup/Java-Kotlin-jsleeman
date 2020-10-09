package com.example.objects;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class CabinetposTest {

    @Test
    public void getShelf() {
        Cabinetpos a = new Cabinetpos(1, 2, "heinz");
        assertEquals(a.getShelf(), 1);
    }

    @Test
    public void getX() {
        Cabinetpos a = new Cabinetpos(1, 2, "heinz");
        assertEquals(a.getX(), 2);
    }

    @Test
    public void getBrand() {
        Cabinetpos a = new Cabinetpos(1, 2, "heinz");
        assertEquals(a.getBrand(), "heinz");
    }

    @Test
    public void addJarsOnShelf() {
        JarDetails jd = new JarDetails();
        jd.addJellyJarToCab(new Cabinetpos(2, 1, "aa"),
                new JellyJar(10.0,5.0, true));
        Set<Cabinetpos> jellyjars = jd.getJellyJars();
        Cabinetpos.addJarsOnShelf(jellyjars, 2 , jd.getJellyJars());

        for (Cabinetpos pos : jellyjars){
            assertEquals(pos.getShelf(), 2);
        }

    }
    //compares by name, shelf, then x
    //name is case sensitive for order
    @Test
    public void compareTo() {
        Cabinetpos a = new Cabinetpos(1, 2, "french"); //1
        Cabinetpos b = new Cabinetpos(1, 3, "heinz");//2
        Cabinetpos c = new Cabinetpos(1, 1, "smuckers");//3
        Cabinetpos d = new Cabinetpos(1, 2, "smuckers");//4
        Cabinetpos e = new Cabinetpos(3, 1, "smuckers");//5
        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(c) < 0);
        assertTrue(c.compareTo(d) < 0);
        assertTrue(d.compareTo(e) < 0);
        assertTrue(e.compareTo(a) > 0);
        assertTrue(a.compareTo(a) == 0);
    }

    @Test
    public void testHashCode() {
        Cabinetpos a = new Cabinetpos(1, 2, "french"); //1
        Cabinetpos b = new Cabinetpos(1, 3, "heinz");//2
        Cabinetpos c = new Cabinetpos(1, 2, "french"); //1
        assertEquals(a.hashCode(), c.hashCode());
        assertNotEquals(a.hashCode(),b.hashCode());
    }
}