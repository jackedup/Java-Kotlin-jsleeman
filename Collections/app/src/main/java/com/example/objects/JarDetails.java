package com.example.objects;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.List;


public class JarDetails {
    private Map<Cabinetpos, JellyJar> JellyJars = new TreeMap<Cabinetpos, JellyJar>();
    private Map<Cabinetpos, MayoJar> MayoJars = new TreeMap<Cabinetpos, MayoJar>();
    private List<String> CabinetUsers = new ArrayList<>();

    public void addUserToCab(String user){CabinetUsers.add(user);}
    public void addJellyJarToCab(Cabinetpos pos, JellyJar jellyJar){JellyJars.put(pos, jellyJar);}
    public void addMayoJarToCab(Cabinetpos pos, MayoJar mayoJar){MayoJars.put(pos, mayoJar);}


    public Set<Cabinetpos> getJellyJars(){return JellyJars.keySet();}
    public Set<Cabinetpos> getMayoJars(){return MayoJars.keySet();}


    public List<String> getCabinetUsers(){return CabinetUsers;}
    public JellyJar getJellyJarAt(Cabinetpos pos){return JellyJars.get(pos);}
    public MayoJar getMayoJarAt(Cabinetpos pos){return MayoJars.get(pos);}

    public Set<Cabinetpos> jellyJarsLocOnShelf(int shelf){
        Set<Cabinetpos> jellyjarsonshelf = getJellyJars();
        Cabinetpos.addJarsOnShelf(jellyjarsonshelf, shelf , getJellyJars());
        return jellyjarsonshelf;
    }
    public Set<Cabinetpos> mayoJarsLocOnShelf(int shelf){
        Set<Cabinetpos> mayojarsonshelf = getMayoJars();
        Cabinetpos.addJarsOnShelf(mayojarsonshelf, shelf , getJellyJars());
        return mayojarsonshelf;
    }
    public void orderUsers(){
        Collections.sort(CabinetUsers);
    }


}
