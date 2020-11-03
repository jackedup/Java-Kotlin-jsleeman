package com.example.kattisbus;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class KattisBusTest {

    @Test
    public void main() {
    }
    @Test
    public void sampleData() throws Exception {
        String input = "6\n" +
                "180 141 174 143 142 175" ;
        String expected = "141-143 174 175 180";

        Scanner in = new Scanner(input);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bos);
        KattisBus KB = new KattisBus(in, ps);
        KB.run();
        ps.close();
        String result = bos.toString("UTF-8");
        assertEquals(expected , result);


    }
    @Test
    public void run() {
    }

    @Test
    public void doCommand() {
    }

    @Test
    public void readCommand() {
    }
}