package com.africanbigcats;

/*
 * Lion is a sub class of Panthera class
 */

public class Lion extends Panthera{
    // constructor
    public Lion(String name) {
        // call the super-class (parent) to instatiate it
        super(name);
        // initialize attributes
        this.setSpecies("lion");
    }
    
    // serializes attributes into a string
    @Override // override superclass method
    public String toString() {
        String s;
    
        // since the object is complex, we return a JSON formatted string
        s = "{ ";
        s += "name: " + name();
        s += ", ";
        s += "species: " + species();
        s += ", ";
        s += "longitude: " + longitude();
        s += ", ";
        s += "latitude: " + latitude();
        s += ", ";
        s += "weight: " + getWeight();
        s += ", ";
        s += "speed: " + speed();
        s += ", ";
        s += "fur: " + fur();
        s += " }";
        return s;
    }
    
    public String fur() {
        return "mane";
    }
    
}
