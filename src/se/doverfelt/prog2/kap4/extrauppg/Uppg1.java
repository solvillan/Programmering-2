package se.doverfelt.prog2.kap4.extrauppg;

import javax.swing.*;
import java.awt.*;

/**
 * Filnamn: Uppg1.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-30
 */
public class Uppg1 {

    public static void main(String[] args) {
        Carowner c1 = new Carowner(getInput("Namn"), getInput("Address"), getInputInt("Age"));
        Carowner c2 = new Carowner("Sara", "Skogsgatan 2", 25);

        Car car1 = new Car("ABC 123", "Volvo S-40", "Silver", 1.6f);
        Car car2 = new Car("DPK 420", "Toyota Camry", "Red", 2.4f);
        c1.buyCar(car2);
        showf("Owner is %s who lives at %s and is %d years old. %1$s owns %s", c1.getName(), c1.getAddress(), c1.getAge(), c1.owns());
        c2.buyCar(car1);
        showf(c2.getName() + " owns " + c2.owns());
        showf(c1.getName() + " owns " + c1.owns());

        Carowner c3 = new Carowner("Kalle", "Kallegatan 13", 35);
        String answer = getInput(String.format("Do %s want to buy a car? [Yes / No]", c3.getName()));
        if (answer.toLowerCase().equals("yes")) {
            showf("%s wants to buy a car.", c3.getName());
            answer = getInput("Do %s want to sell a car? [Yes / No]", c2.getName());
            if (c2.owns() != null && answer.toLowerCase().equals("yes")) {
                showf("%s wants to sell a car.", c2.getName());
                Car auto = c2.owns();
                c2.sellCar();
                c3.buyCar(auto);
                showf("%s owned %s. \nIt has now been sold to %s", c2.getName(), auto, c3.getName());
                showf("%s now owns %s. \nIt was bought from %s", c3.getName(), c3.owns(), c2.getName());
            } else if (!answer.toLowerCase().equals("yes")) {
                showf("%s do not want to sell a car.", c2.getName());
            } else if (c2.owns() == null) {
                showf("%s can't sell a car, %1s doesn't own a car.");
            }
        } else {
            showf("%s do not want to buy a car.", c3.getName());
        }

        Carowner owner1 = car1.owner();
        Carowner owner2 = car2.owner();

        showf("Owner #1 is called %s", owner1.getName());
        showf("Owner #2 is called %s", owner2.getName());
        showf("%s is owned by %s", car1, car1.owner().getName());
        showf("%s is owned by %s", car2, car2.owner().getName());

        Carowner p4 = new Carowner("James Moriarty", "London", 0x42);
        Carowner p5 = new Carowner("Sherlock Holmes", "Baker Street 221B", 0x42);
        Car car3 = new Car("AAA007", "Citroën C4 2012", "Silver Metallic", 1.2f);
        p5.buyCar(car3);

        int bid = getInputInt("How much is %s willing to offer for %s", p4.getName(), car3);
        if (bid >= 210000) {
            showf("The %s is all yours, %s!", car3.getMake(), p4.getName());
            p4.buyCar(p5.owns());
            p5.sellCar();
        } else {
            showf("%d SEK is to cheap, %s asked for at least 210000 SEK", bid, p5.getName());
        }
    }

    public static void showf(String text, Object... objects) {
        JOptionPane.showMessageDialog(null, String.format(text, objects));
    }

    public static String getInput(String message, Object... objects) {
        return JOptionPane.showInputDialog(null, String.format(message, objects));
    }

    public static int getInputInt(String message, Object... objects) {
        try {
            return Integer.parseInt(getInput(message, objects));
        } catch (NumberFormatException e) {
            e.printStackTrace(System.err);
            return Integer.MAX_VALUE;
        }
    }

}
