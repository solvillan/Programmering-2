package se.doverfelt.prog2.colorrobot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rickard.doverfelt on 2015-11-25.
 */
public class ColorRobot {

    private ArrayList<Colors> path;

    public ColorRobot(int tries, ArrayList<Colors> path) {
        this.path = path;
        System.out.println(getPath(tries));
    }

    private String getPath(int tries) {
        String out = "";

        for (int i = 0; i < tries; i++) {
            int r = path.indexOf(Colors.RED);
            int g = path.indexOf(Colors.GREEN);
            int b = path.indexOf(Colors.BLUE);
            int index = 0;

            if (r > g && r > b) {
                index = r;
                out += "R";
            } else if (g > r && g > b) {
                index = g;
                out += "G";
            } else if (b > r && b > g) {
                index = b;
                out += "B";
            }
            for (int j = 0; j <= index; j++) {
                path.remove(0);
            }
        }

        return out;
    }

    public enum Colors {
        RED, BLUE, GREEN
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tries = Integer.parseInt(s.nextLine());
        ArrayList<Colors> path = new ArrayList<>();
        String[] chars = s.nextLine().split("");

        for (String in : chars) {
            switch (in) {
                case "R":
                    path.add(Colors.RED);
                    break;
                case "G":
                    path.add(Colors.GREEN);
                    break;
                case "B":
                    path.add(Colors.BLUE);
                    break;
            }
        }

        new ColorRobot(tries, path);
    }



}
