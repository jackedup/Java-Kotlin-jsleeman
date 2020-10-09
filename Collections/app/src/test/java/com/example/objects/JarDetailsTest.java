package com.example.objects;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class JarDetailsTest {

    @Test
    public void addUserToCab() {
        JarDetails jd = new JarDetails();
        jd.addUserToCab("Billy");
        jd.addUserToCab("Mike");
        jd.addUserToCab("Tre");
        assertTrue(jd.getCabinetUsers().size() == 3);
    }

    @Test
    public void addJellyJarToCab() {
        JarDetails jd = new JarDetails();
        JellyJar jar = new JellyJar(10.0,4.0, true);
        Cabinetpos cab = new Cabinetpos(1, 2, "heinz");
        jd.addJellyJarToCab(cab, jar);
        assertTrue(jd.getJellyJars().size() == 1);
    }

    @Test
    public void addMayoJarToCab() {
        JarDetails jd = new JarDetails();
        MayoJar jar = new MayoJar(10.0,6.0, false);
        Cabinetpos cab = new Cabinetpos(1, 2, "heinz");
        jd.addMayoJarToCab(cab, jar);
        assertEquals(jd.getMayoJars().toArray().length, 1);
    }


    @Test
    public void getJellyJarAt() {
        JarDetails jd = new JarDetails();

        JellyJar jar1 = new JellyJar(10.0,4.0, true);
        JellyJar jar2 = new JellyJar(10.0,4.0, false);

        Cabinetpos cab1 = new Cabinetpos(2, 2, "heinz");
        Cabinetpos cab2 = new Cabinetpos(1, 2, "french");

        jd.addJellyJarToCab(cab1, jar1);
        jd.addJellyJarToCab(cab2, jar2);
        assertTrue(jd.getJellyJarAt(cab1).getLidOn());
        assertFalse(jd.getJellyJarAt(cab2).getLidOn());


    }

    @Test
    public void getMayoJarAt() {
        JarDetails jd = new JarDetails();

        MayoJar jar1 = new MayoJar(10.0,4.0, true);
        MayoJar jar2 = new MayoJar(10.0,4.0, false);

        Cabinetpos cab1 = new Cabinetpos(2, 2, "heinz");
        Cabinetpos cab2 = new Cabinetpos(1, 2, "french");

        jd.addMayoJarToCab(cab1, jar1);
        jd.addMayoJarToCab(cab2, jar2);
        assertTrue(jd.getMayoJarAt(cab1).getLidOn());
        assertFalse(jd.getMayoJarAt(cab2).getLidOn());

    }

    @Test
    public void testjellyJarsLocOnShelf() {
        JarDetails jd = new JarDetails();

        JellyJar jar1 = new JellyJar(10.0,4.0, true);
        JellyJar jar2 = new JellyJar(10.0,4.0, false);

        Cabinetpos cab1 = new Cabinetpos(2, 2, "heinz");
        Cabinetpos cab2 = new Cabinetpos(1, 2, "french");

        jd.addJellyJarToCab(cab1, jar1);
        jd.addJellyJarToCab(cab2, jar2);
        Set<Cabinetpos> pos = jd.jellyJarsLocOnShelf(1);
        assertTrue(pos.iterator().next() == cab2);
    }

    @Test
    public void mayoJarsLocOnShelf() {
        JarDetails jd = new JarDetails();

        MayoJar jar1 = new MayoJar(10.0,4.0, true);
       MayoJar jar2 = new MayoJar(10.0,4.0, false);

        Cabinetpos cab1 = new Cabinetpos(2, 2, "heinz");
        Cabinetpos cab2 = new Cabinetpos(2, 2, "french");

        jd.addMayoJarToCab(cab1, jar1);
        jd.addMayoJarToCab(cab2, jar2);
        Set<Cabinetpos> pos = jd.mayoJarsLocOnShelf(1);
        assertTrue(pos.iterator().next() == cab2);
    }

    @Test
    public void orderUsers() {
        JarDetails jd = new JarDetails();
        jd.addUserToCab("jack");//2
        jd.addUserToCab("luke");//4
        jd.addUserToCab("connor");//1
        jd.addUserToCab("jake");//3

        jd.orderUsers();
        List<String> lst = jd.getCabinetUsers();
        assertTrue(lst.get(0).compareTo(lst.get(1)) < 0);
        assertTrue(lst.get(1).compareTo(lst.get(2)) < 0);
        assertTrue(lst.get(2).compareTo(lst.get(3)) < 0);
        assertTrue(lst.get(3).compareTo(lst.get(1)) > 0);

    }
}