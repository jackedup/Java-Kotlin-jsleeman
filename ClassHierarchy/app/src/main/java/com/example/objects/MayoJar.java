package com.example.objects;

import java.util.ArrayList;
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
    public class MoldyMayo implements Mold{
         public boolean isMoldHere(double junk){return true;}
    }

    ArrayList< Mold > Molds = new ArrayList<Mold>();

    public MayoJar(double capacity) {
        super(capacity);
        Molds.add(new MoldyArea(0.2,3.0));
    }

    public MayoJar(double capacity, double fluidLevel) {
        super(capacity, fluidLevel);
    }

    public MayoJar(double capacity, double fluidLevel, boolean isLidOn) {
        super(capacity, fluidLevel, isLidOn);
    }
    public void setMayoLevel(double mayoLevel){
        setFluidLevel(mayoLevel);
    }
    public double getMayoLevel(){
        return getFluidLevel();
    }


    private boolean spoiled = false;
}
