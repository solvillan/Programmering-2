package se.doverfelt.prog2.kap3.uppg3_9;

import java.text.Normalizer;
import java.util.Scanner;

/**
 * Filnamn: Military.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-23
 */

public class Military {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Command command1 = getCommand(1);
        Command command2 = getCommand(2);
        //System.out.println(command1);
        //System.out.println(command2);
        if (!command1.getCommand().equals(command2.getCommand())) {
            if (command1.getDegree().compareTo(command2.getDegree()) <= 0) {
                showMessage(command1.getCommand().toString(), command1.getDegree().toString());
            } else {
                showMessage(command2.getCommand().toString(), command2.getDegree().toString());
            }
        } else {
            showMessage(command1.getCommand().toString(), command1.getDegree().toString());
        }
    }

    public static Command getCommand(int number) {

        Degrees d = parseDegree(getInput("Degree " + number, "Enter degree"));
        Commands c = parseCommand(getInput("Command " + number, "Enter command"));

        return new Command(d, c);
    }

    public static String enumerize(String in) {
        return Normalizer.normalize(in.toUpperCase(), Normalizer.Form.NFKD).replaceAll("\\p{M}", "").replaceAll(" ", "_");
    }

    private static Degrees parseDegree(String in) {
        String out = enumerize(in);
        //System.out.println(out);
        Degrees d = null;
        try {
            d = Degrees.valueOf(Degrees.class, out);
        } catch (IllegalArgumentException ignored) {
            showMessage("Invalid degree", "ERROR");
            System.exit(-1);
        }
        return d;
    }

    private static Commands parseCommand(String in) {
        String out = enumerize(in);
        //System.out.println(out);
        Commands d = null;
        try {
            d = Commands.valueOf(Commands.class, out);
        } catch (IllegalArgumentException ignored) {
            showMessage("Invalid Command", "ERROR");
            System.exit(-1);
        }
        return d;
    }

    public static String getInput(String title, String message) {
        showMessage(message + ": ", title);
        return scanner.nextLine();
    }

    public static void showMessage(String message, String title) {
        System.out.print("["+title+"] " + message);
    }
}