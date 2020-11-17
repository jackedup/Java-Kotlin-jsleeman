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

        Arrays.sort(busesint);
        int endbus = 0;
        int i;
        for (i = 0; i < busnum; i++) {
            int currentbus = busesint[i];
            int k = 1;
            boolean done = false;
            if (i + k <= busnum && !done) {
                while (currentbus + k == busesint[i + k]) {
                    endbus = busesint[k];
                    k++;
                }
                if (k > 2) {

                    out.print(currentbus + "-" + endbus);
                    i += k -1;
                } else {
                    out.print(currentbus);
                    done = true;
                }
            }else{ out.print(currentbus); }
            if (i < busnum -1){
                out.print(" ");
            }else out.print("\n");
        }
    }
    public boolean readCommand() {
        if (in.hasNextLine()) {

            String line = in.nextLine();
            busnum = Integer.parseInt(line);
            busesint = new int[busnum];
            if (in.hasNextLine()) {
                line = in.nextLine();
                busesstr = line.split(" ");
            }
            for(int i = 0; i < busnum; i++){
                busesint[i] = Integer.parseInt(busesstr[i]);
            }
            return true;
        } else {
            return false;
        }
    }


}
