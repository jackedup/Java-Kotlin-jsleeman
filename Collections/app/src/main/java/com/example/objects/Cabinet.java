package com.example.objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Cabinet that stores shelves of jars.
public class Cabinet {
    private List<List> Shelves;

    //initializes a cabinet that has shelves and a max width of jars.
    public void Cabinet(int shelves, int width){
        Shelves = new ArrayList<List>();
        for (int i = 0; i < shelves; i++){
            Shelves.add(new ArrayList<Jar>(width));
        }
    }
    public void sortShelfByFluidLevel(int shelf){
        Collections.sort(Shelves.get(shelf));
    }
}
