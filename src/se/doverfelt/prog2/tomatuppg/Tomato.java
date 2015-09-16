package se.doverfelt.prog2.tomatuppg;

/**
 * @author Rickard Doverfelt
 *         Datum: 2015-09-16
 *         Filnamn: Tomato.java
 */
public class Tomato {

    private boolean mature;


    public boolean isMature() {
        return mature;
    }

    public void setMature(boolean mature) {
        this.mature = mature;
    }

    public Tomato(boolean mature) {
        this.mature = mature;
    }

}
