package se.doverfelt.prog2.kap4.uppg2;

/**
 * Filnamn: Train.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-09
 */
public class Train extends Vehicle {

    int vagons;

    public Train(int speed, int weight, int vagons) {
        super(speed, weight);
        this.vagons = vagons;
    }

    public void connectVagon() {
        vagons++;
    }

}
