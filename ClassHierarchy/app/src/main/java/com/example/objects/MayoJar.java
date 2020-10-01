package com.example.objects;

import java.util.ArrayList;
import java.util.Random;

public class MayoJar extends DefaultJar{
    interface Mold{
        boolean isMoldHere(double height);
    }

    public class MoldyArea implements Mold{
        double lowerMoldHeight;
        double upperMoldHeight;
        MoldyArea(double lowerMoldHeight, double upperMoldHeight){
            this.lowerMoldHeight = lowerMoldHeight;
            this.upperMoldHeight = upperMoldHeight;
        }

        public boolean isMoldHere(double height) {
            return height < upperMoldHeight &&
                    height > lowerMoldHeight;
        }
    }

    ArrayList< Mold > Molds = new ArrayList<>();

    public MayoJar(double capacity) {
        super(capacity);
        Random rand = new Random();
        double hi = rand.nextDouble() * capacity;
        double lo = rand.nextDouble()* capacity;
        double temp;
        if(hi < lo){temp = lo; lo = hi; hi = temp;}
        Molds.add(new MoldyArea(lo,hi));
    }

    public MayoJar(double capacity, double fluidLevel) {
        super(capacity, fluidLevel);
        Random rand = new Random();
        double hi = rand.nextDouble() * capacity;
        double lo = rand.nextDouble()* capacity;
        double temp;
        if(hi < lo){temp = lo; lo = hi; hi = temp;}
        Molds.add(new MoldyArea(lo,hi));
    }

    public MayoJar(double capacity, double fluidLevel, boolean isLidOn) {
        super(capacity, fluidLevel, isLidOn);
        Random rand = new Random();
        double hi = rand.nextDouble() * capacity;
        double lo = rand.nextDouble()* capacity;
        double temp;
        if(hi < lo){temp = lo; lo = hi; hi = temp;}
        Molds.add(new MoldyArea(lo,hi));
    }
    public void setMayoLevel(double mayoLevel){
        setFluidLevel(mayoLevel);
    }
    public double getMayoLevel(){
        return getFluidLevel();
    }


    private boolean spoiled = false;
}
