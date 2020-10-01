package com.example.objects;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MayoJarTest {



    @Test
    public void setMayoLevel() {
        MayoJar instance = new MayoJar(10.0);
        instance.setMayoLevel(8.0);
        assertEquals(8.0, instance.getMayoLevel(), 0.0);
        instance = new MayoJar(10.0,6.4);
        assertEquals(8.0, instance.getMayoLevel(), 6.4);
    }
    @Test
    public void checkMold(){
        MayoJar instance = new MayoJar(10.0, 7.0, true);
        instance.Molds.get(0).isMoldHere(4.0);
    }
}