package com.africanbigcats;

import java.util.Random;
/*
 * Panthera base class that simulates GPS information
 */
public class Panthera extends PantheraGPS {

    /*
        TIP:
        Students will need to add additional attributes and methods to complete this classes implementation.
     */

    // constants 
    private final Integer maxWeight = 600;      // Panthera's max weight
    private final Integer minWeight = 10;       // Panthera's min weight

    // attributes
    private Integer weight;                     // Panthera's weight
    private Random weightRandom;
    private Float speed;                        // Panthera's speed
    private Random speedRandom;

    // constructor
    public Panthera(String name) {

        // call the super-class (parent) to instatiate it
        super(name);

        // initialize attributes
        this.setSpecies("panthera");

    }

    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;

        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + this.name();
        s += ", ";
        s += "species: " + this.species();
        s += ", ";
        s += "longitude: " + this.longitude();
        s += ", ";
        s += "latitude: " + this.latitude();
        s += " }";

        return s;

    }


}
