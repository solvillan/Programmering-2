package se.doverfelt.prog2.robotRiot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Filnamn: RobotRiot.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-18
 */
public class RobotRiot {

    public static EnumTile[][] tiles;
    private static ArrayList<PathFinder> pathFinders = new ArrayList<>();
    private static long timeStamp;

    public RobotRiot(int n, int m, String[] lines) {
        parseTiles(n, m, lines);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (tiles[x][y] == EnumTile.ROBOT) {
                    findPath(x, y, n, m);
                }
            }
        }
        while (!isFinished()) {

        }
        boolean result = false;
        for (PathFinder pathFinder : pathFinders) {
            result = result || pathFinder.escaped;
        }
        if (result) {
            System.out.println("Death to humans");
        } else {
            System.out.println("We are safe");
        }
        System.out.println(System.currentTimeMillis()-timeStamp);
    }

    private boolean isFinished() {
        if (pathFinders.isEmpty()) {
            return false;
        } else {
            boolean out = true;
            for (PathFinder pathFinder : pathFinders) {
                out = out && !pathFinder.t.isAlive();
            }
            return out;
        }
    }

    private void findPath(int x, int y, int n, int m) {
        //System.out.println("Should find path for " + x + "; " + y);
        PathFinder pf = new PathFinder(tiles, x, y, n, m);
        pathFinders.add(pf);
        pf.start();
    }

    private void parseTiles(int n, int m, String[] lines) {
        tiles = new EnumTile[n][m];
        for (int i = 0; i < n; i++) {
            String[] chars = lines[i].split("");
            for (int j = 0; j < m; j++) {
                switch (chars[j]) {
                    case ".":
                        tiles[i][j] = EnumTile.FLOOR;
                        //System.out.println("FLOOR");
                        break;
                    case "#":
                        tiles[i][j] = EnumTile.WALL;
                        //System.out.println("WALL");
                        break;
                    case "X":
                        tiles[i][j] = EnumTile.ROBOT;
                        //System.out.println("ROBOT");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] in = s.nextLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = s.nextLine();
        }
        timeStamp = System.currentTimeMillis();
        new RobotRiot(n, m, lines);
    }
}
