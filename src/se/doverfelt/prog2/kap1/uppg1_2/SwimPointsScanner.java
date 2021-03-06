package se.doverfelt.prog2.kap1.uppg1_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Filnamn: SwimPointsScanner.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-09-09
 */
public class SwimPointsScanner {

    LinkedList<Integer> points = new LinkedList<>();
    int level;
    Scanner scanner;

    public static void main(String[] args) {
        new SwimPointsScanner();
    }

    public SwimPointsScanner() {
        scanner = new Scanner(System.in);
        level = -1;
        while (level == -1) {
            level = getInt("Enter level of difficulty");
        }
        for (int i = 0; i < 7; i++) {
            int k = -1;
            while (k == -1) {
                k = getInt("Enter points for judge " + (i + 1));
            }
            points.add(k);
        }

        Collections.sort(points);

        points.removeFirst();
        points.removeLast();

        double total = 0;

        for (Integer point : points) {
            total += point;
        }

        showMessage(String.format("Final score: %.1f", (double) ((total / points.size()) * 3 * level)), "Result");
    }

    public int getInt(String message) {
        int out = -2;
        while (out == -2) {
            showMessage(message, "Input");
            try {
                String in = scanner.nextLine();
                out = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                showMessage("Input not a number!", "Error");
                out = -1;
                break;
            }
            if (out < 0 || out > 10) out = -2;
        }

        return out;
    }

    public void showMessage(String message, String title) {
        System.out.println("["+title+"] " + message);
    }
}