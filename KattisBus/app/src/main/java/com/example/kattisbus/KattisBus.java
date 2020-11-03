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
    int [] busesint = new int[1000];

    String[] command = new String[0];
    public void doCommand() {

        Arrays.sort(busesint);
        int endbus = 0;
        for (int i = 0; i < busnum - 2; i++){
            int currentbus = busesint[i];
            int k =1;
            for (int j = currentbus; j< busnum; j++) {
                while (currentbus == busesint[j] + k) {
                    endbus = busesint[j];
                    k++;
                }
                if(k > 1) {
                    out.print(currentbus + "-" + endbus + " ");
                    i +=k;
                }
                else out.print(currentbus + " ");

            }
        }

    }
    public boolean readCommand() {
        if (in.hasNextLine()) {
            String line = in.nextLine();
            busnum = Integer.parseInt(line);
            if (in.hasNextLine()) {
                line = in.nextLine();
                busesstr = line.split(" ");
            }
            for(int i = 0; i < busnum; i++){
                System.out.println(busesstr[i]);
                System.out.println(i);
                busesint[i] = Integer.parseInt(busesstr[i]);
            }
            return true;
        } else {
            return false;
        }
    }


}
