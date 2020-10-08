package com.example.objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Cabinet that stores shelves of jars.
public class Cabinet {
    private List<List> Shelves;

    //initializes a cabinet that has shelves and a max width of jars.
    //Not the best use of a list i realize after building this
    public Cabinet(int shelves, int width){
        this.Shelves = new ArrayList<List>(shelves);
        for (int i = 0; i < shelves; i++){
            Shelves.add(new ArrayList<Jar>(width));
            for(int j = 0; j < width - 1; j++) {
                this.Shelves.get(i).add(j, null);
            }
        }
    }
    public Jar getJar(int shelf,int xloc){
        return (Jar)(this.Shelves.get(shelf).get(xloc));
    }
    public void addJar(Jar jar, int shelf, int xloc){
        if (getJar(shelf, xloc) != null){
            String m = "Spot" + shelf + ", " + xloc + " already taken";
            throw new IllegalArgumentException(m);
        }
        this.Shelves.get(shelf).set(xloc, jar);
    }

    public void sortShelfByFluidLevel(int shelf){
        Collections.sort(Shelves.get(shelf));
    }
}
