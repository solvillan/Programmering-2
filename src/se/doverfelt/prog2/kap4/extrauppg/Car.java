package se.doverfelt.prog2.kap4.extrauppg;

import java.awt.*;

/**
 * Filnamn: Car.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-30
 */
public class Car {
    private Carowner owner;
    private String reg, make, color;
    private float volume;

    public Car(String reg, String make, String color, float volume) {
        this.reg = reg;
        this.make = make;
        this.color = color;
        this.volume = volume;
    }

    public void sold() {
        owner = null;
    }

    public Carowner owner() {
        return this.owner;
    }

    public void bought(Carowner newOwner) {
        owner = newOwner;
    }

    public String getColor() {
        return color;
    }

    public float getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return reg + " | " + volume + "L " + color + " " + make;
    }

    public String getMake() {
        return make;
    }
}
