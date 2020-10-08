package com.example.objects;

import org.junit.Test;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class CabinetTest {
    public DefaultJar randomDefaultJar(){
        //Local random is the only way to do nextDouble(int, int) for some reason
        double capacity = ThreadLocalRandom.current().nextDouble(1, 10);
        double fluidlevel = ThreadLocalRandom.current().nextDouble(1, capacity);
        boolean islidon = ThreadLocalRandom.current().nextBoolean();
        return new DefaultJar(capacity, fluidlevel, islidon);
    }
    @Test
    public void cabinet() {
        //checks if you can fill a Cabinet full
        Cabinet cabinet = new Cabinet(4,5);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                cabinet.addJar(randomDefaultJar(), i, j);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                assertTrue(cabinet.getJar(i,j) != null);
            }
        }

    }
    @Test(expected = IllegalArgumentException.class)
    public void badCabinetAdd(){
        Cabinet cabinet = new Cabinet(4,5);
        cabinet.addJar(randomDefaultJar(), 0, 0);
        cabinet.addJar(randomDefaultJar(), 0, 0);
    }
    @Test
    public void sortShelfByFluidLevel() {
        Cabinet cabinet = new Cabinet(4,5);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                cabinet.addJar(randomDefaultJar(), i, j);
            }
        }

        for (int i = 0; i < 3; i++) {
            cabinet.sortShelfByFluidLevel(i);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                assertTrue(cabinet.getJar(i,j).getFluidLevel() >=
                        cabinet.getJar(i,j-1).getFluidLevel());
            }
        }
    }
}