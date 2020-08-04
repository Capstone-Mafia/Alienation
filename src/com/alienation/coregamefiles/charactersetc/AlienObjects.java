package com.alienation.coregamefiles.charactersetc;
import java.util.*;

public class AlienObjects {
    static List<Alien> alienObjs = new ArrayList<>();
    static{
        Alien obj1 = new AlienSuperhumanoid(50);
        Alien obj2 = new AlienHumanoid(10);
        Alien obj3 = new AlienCanine(6);
        Alien obj4 = new AlienVermin(4);
        alienObjs.add(obj1);
        alienObjs.add(obj2);
        alienObjs.add(obj3);
        alienObjs.add(obj4);

    }

    public static Optional<Alien> getAlien(String alienName){
        for (Alien alien : alienObjs){
            System.out.println(alien.getAlienName());
            if (alien.getAlienName().equals(alienName)){
                return Optional.of(alien);
            }
        }
        return Optional.empty();
    }





}
