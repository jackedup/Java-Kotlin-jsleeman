package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void concattenation_isCorrect() {assertEquals("Hello m8", "Hello" + " m8");}
    @Test
    public void stringtoint_isCorrect(){assertEquals(Integer.parseInt("1"), 1);}
    @Test
    public void subtract_isCorrect(){assertEquals(4,8-4);}
}