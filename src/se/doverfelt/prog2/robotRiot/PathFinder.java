package se.doverfelt.prog2.robotRiot;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Filnamn: PathFinder.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-18
 */
public class PathFinder implements Runnable {

    private static int x, y;
    private static EnumTile[][] tiles;
    private static ArrayList<String> checked = new ArrayList<>() , toCheck = new ArrayList<>();
    private static boolean escaped = false;

    public PathFinder(EnumTile[][] tilesOrig, int xIn, int yIn) {
        tiles = tilesOrig;
        x = xIn;
        y = yIn;
        placeCheckPos(x, y);
    }

    private static int[] parsePos(String pos) {
        String[] positions = pos.split(";");
        return new int[]{Integer.parseInt(positions[0]), Integer.parseInt(positions[1])};
    }

    private static void placeCheckPos(int x, int y) {
        toCheck.add(x+";"+y);
    }

    @Override
    public void run() {
        while (!escaped && !toCheck.isEmpty()) {
            for (String s : toCheck) {
                toCheck.remove(s);
                
            }
        }
    }
}
