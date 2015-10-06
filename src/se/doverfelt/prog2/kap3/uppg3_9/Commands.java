package se.doverfelt.prog2.kap3.uppg3_9;

/**
 * Filnamn: Commands.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-23
 */
public enum Commands {
    HOGER_OM("Höger om"), VANSTER_OM("Vänster om"), HELT_OM("Helt om"), FRAMAT_MARSCH("Framåt marsch"), HALT("Halt"),
    GIV_AKT("Giv akt"), MANOVER("Manöver"), LEDIGA("Lediga"), HOGER_VANSTER_OM("Höger vänster om");


    public final String command;

    Commands(String s) {
        command = s;
    }

    public String toString() {
        return command;
    }
}
