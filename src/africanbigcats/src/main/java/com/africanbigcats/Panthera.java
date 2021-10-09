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

        // seed the random number generators for repeatable results
        this.weightRandom = new Random();
        this.weightRandom.setSeed(this.seed(name + "weight"));
        // set weight = weightRandom
        this.weight = weightRandom.nextInt(maxWeight - minWeight + 1) + minWeight;

        // seed the random number generators for repeatable results
        this.speedRandom = new Random();
        this.speedRandom.setSeed(this.seed(name + "speed"));
        // set speed = speedRandom
        this.speed = (speedRandom.nextInt((int)maxSpeed * 100 - (int)minSpeed + 1) + (int)minSpeed) / 100.00f;
    }

    // make a seed, based on the name
    private Integer seed(String s) {
        Integer seed = 0;

        for (Integer i = 0; i < s.length() ; i++) {
            char ch = s.charAt(i);
            seed += (int) ch;
        }

        return seed;
    }

    // getters
    public Integer getWeight(){
        return this.weight;
    }
    public Float speed(){
        return this.speed;
    }

    // roar method
    public void roar(){
        System.out.print("Rrrrrrrrroooooooaaaaarrrrr!");
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
        s += ", ";
        s += "weight: " + this.getWeight();
        s += ", ";
        s += "speed: " + this.speed();
        s += " }";

        return s;

    }


}
