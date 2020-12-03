package com.example.drinkreminder;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class CalculateObjTest {
    Context context;

    @Before
    public void setup() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void setOzGoal() {
        CalculateObj calcObj = new CalculateObj();
        calcObj.setOzGoal(100);
        assertEquals(calcObj.ozGoal, 100);
    }

    @Test
    public void setNumRem() {
        CalculateObj calcObj = new CalculateObj();
        calcObj.setNumRem(100);
        assertEquals(calcObj.numRem, 100);
    }
    @Test
    public void calculateTimes(){
        Calendar now = Calendar.getInstance();
        CalculateObj calcObj = new CalculateObj();
        calcObj.setOzGoal(100);
        calcObj.setNumRem(10);
        calcObj.calculateTimes(now, context);
        assertEquals(calcObj.ozToDrink, 10);
    }
    @Test
    public void setNotification() {


    }
}