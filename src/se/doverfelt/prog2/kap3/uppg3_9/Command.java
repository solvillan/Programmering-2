package se.doverfelt.prog2.kap3.uppg3_9;

/**
 * Filnamn: Command.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-23
 */
public class Command {

    private final Degrees degree;
    private final Commands command;

    public Commands getCommand() {return command;}
    public Degrees getDegree() {return degree;}


    public Command(Degrees degree, Commands command) {
        this.degree = degree;
        this.command = command;
    }

    public String toString() {
        return degree + ":" + command;
    }

}
