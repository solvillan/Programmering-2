package se.doverfelt.prog2.tomatuppg;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rickard Doverfelt
 *         Datum: 2015-09-16
 *         Filnamn: TomatoSim.java
 */
public class TomatoSim {
    private ArrayList<Tomato> tomatoes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private int[] mature = new int[3];
    private int total, time;

    public static void main(String[] args) {
        new TomatoSim();
    }

    public TomatoSim() {
        getTotalTomatoes();
        getMatureTomatoes();
        generateTomatoes();
        getTime();
        calculateMaturity();
        outputResults();
    }

    private void outputResults() {
        showMessage(mature.length + " tomatoes are mature.", "Result");
        String matureTomatoes = "";
        for (int i : mature) {
            matureTomatoes += i+1 + " ";
        }
        showMessage("Tomatoes nr. \n\t\t " + matureTomatoes + "\n\t\t are mature.", "Result");
    }

    public void addMature(int index) {
        int[] old = mature;
        int[] newSub = new int[old.length+1];
        for (int i = 0; i < old.length; i++) {
            newSub[i] = old[i];
        }
        newSub[old.length] = index;
        mature = newSub;
    }

    private void generateTomatoes() {
        for (int i = 0; i < total; i++) {
            if (i == mature[0] || i == mature[1] || i == mature[2]) {
                tomatoes.add(new Tomato(true));
            } else {
                tomatoes.add(new Tomato(false));
            }
        }
    }

    private void calculateMaturity() {
        for (int i = 0; i < time; i++) {
            for (int k : mature) {
                if (k-1 >= 0) {
                    if (!tomatoes.get(k-1).isMature()) {
                        tomatoes.get(k-1).setMature(true);
                        addMature(k - 1);
                    }
                }
                if (k+1 < total) {
                    if (!tomatoes.get(k+1).isMature()) {
                        tomatoes.get(k+1).setMature(true);
                        addMature(k + 1);
                    }
                }
            }
        }
    }

    private void getTime() {
        time = -1;
        while (time == -1 || time < 3 || time > 100) {
            time = getInt("Enter the number of days");
        }
    }

    private void getTotalTomatoes() {
        total = -1;
        while (total == -1 || total < 3 || total > 100) {
            total = getInt("Enter total amount of tomatoes (3 <= n <= 100)");
        }
    }

    private void getMatureTomatoes() {
        for (int i = 0; i < 3; i++) {
            mature[i] = -1;
            while (mature[i] == -1 || mature[i] < 0 || mature[i] > total) {
                mature[i] = getInt("Enter mature tomato number " + (i+1) + "(1 <= n <= " + total + ") ")-1;
            }
        }
    }

    public int getInt(String message) {
        int out = -2;
        while (out == -2) {
            showMessage(message + ": ", "Input");
            try {
                String in = scanner.nextLine();
                out = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                showMessage("Input not a number!", "Error");
                out = -1;
                break;
            }
        }

        return out;
    }

    public void showMessage(String message, String title) {
        System.out.println("["+title+"] " + message);
    }

}
