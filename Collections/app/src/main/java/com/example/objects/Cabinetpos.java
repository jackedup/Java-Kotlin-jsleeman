package com.example.objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Cabinet that stores shelves of jars.
public class Cabinetpos implements Comparable<Cabinetpos> {
    private int shelf;
    private int x;
    private String brand;

    public int getShelf(){return shelf;}
    public int getX(){return x;}
    public String getBrand(){return brand;}

    public Cabinetpos(int shelf, int x, String brand){
        this.shelf = shelf;
        this.x = x;
        this.brand = brand;
    }


    public static void addJarsOnShelf(Set<Cabinetpos> results, int shelfo, Set<Cabinetpos> search)  {
        results = search.parallelStream()
                .filter(shelf -> shelf.equals(shelfo))
                .collect(Collectors.toSet());

    }
    @Override
    public int compareTo(Cabinetpos o) {
        int cmp = this.brand.compareTo(o.brand);
        if (cmp != 0) {
            System.out.println("brand " + cmp);
            return cmp;
        }
        cmp = Integer.compare(this.shelf, o.shelf);
        if (cmp != 0) {
            System.out.println("shelf" + cmp);
            return cmp;
        }
        cmp = Integer.compare(this.x, o.x);
        if (cmp != 0) {
            System.out.println("x " + cmp);
            return cmp;
        }
        System.out.println(0);
        return (0);
    }
    public int hashCode(){
        return 10*shelf+5*this.x+this.brand.hashCode()*20;
    }
}
