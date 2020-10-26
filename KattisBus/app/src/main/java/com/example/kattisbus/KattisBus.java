package com.example.kattisbus;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class KattisBus {
    Scanner in;
    PrintStream out;

    public KattisBus(Scanner in, PrintStream out){
        this.in = in;
        this.out = out;
    }
    public static void main(String [] args) throws Exception{
        KattisBus kattisBus = new KattisBus(new Scanner(System.in), System.out);
        kattisBus.run();
    }
    public void run() throws Exception{
        while (readCommand()){
            doCommand();
        }
    }
    int busnum;
    String [] busesstr;
    int [] busesint;

    String[] command = new String[0];
    public void doCommand() {
        for(int i = 0; i < busnum; i++){
            busesint[i] = Integer.parseInt(busesstr[i]);
        }
        Arrays.sort(busesint);
        int currentbus = busesint[0];
        for (int i = 0; i< busnum; i++){
            while(busnum)
        }

    }
    public boolean readCommand() {
        if (in.hasNextLine()) {
            String line = in.nextLine();
            busnum = line.charAt(0);
            if (in.hasNextLine()) {
                line = in.nextLine();
                busesstr = line.split(" ");
            }
            return true;
        } else {
            return false;
        }
    }


}
