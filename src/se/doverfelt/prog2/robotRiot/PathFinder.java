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

    private static int x, y, n, m;
    private static EnumTile[][] tiles;
    private static ArrayList<String> checked = new ArrayList<>() , toCheck = new ArrayList<>();
    private static boolean escaped = false;

    public PathFinder(EnumTile[][] tilesOrig, int xIn, int yIn, int nIn, int mIn) {
        tiles = tilesOrig;
        x = xIn;
        y = yIn;
        n = nIn;
        m = mIn;
        placeCheckPos(x, y);
        Thread t = new Thread(this);
        t.start();
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
            ArrayList<String> tmp = new ArrayList<>();
            for (String s : toCheck) {
                toCheck.remove(s);
                checked.add(s);
                int [] pos = parsePos(s);
                if (tiles[pos[0]-1][pos[1]] == EnumTile.FLOOR && !toCheck.contains((pos[0]-1)+";"+pos[1]) && !checked.contains((pos[0]-1)+";"+pos[1])) {
                    tmp.add((pos[0]-1)+";"+pos[1]);
                }
                if (tiles[pos[0]+1][pos[1]] == EnumTile.FLOOR && !toCheck.contains((pos[0]+1)+";"+pos[1]) && !checked.contains((pos[0]+1)+";"+pos[1])) {
                    tmp.add((pos[0]+1)+";"+pos[1]);
                }
                if (tiles[pos[0]][pos[1]-1] == EnumTile.FLOOR && !toCheck.contains((pos[0])+";"+(pos[1]-1)) && !checked.contains((pos[0])+";"+(pos[1]-1))) {
                    tmp.add((pos[0])+";"+(pos[1]-1));
                }
                if (tiles[pos[0]][pos[1]+1] == EnumTile.FLOOR && !toCheck.contains((pos[0])+";"+(pos[1]+1)) && !checked.contains((pos[0])+";"+(pos[1]+1))) {
                    tmp.add((pos[0])+";"+(pos[1]+1));
                }
                if (pos[0]-1 == 0 || pos[0]+1 == m || pos[1]-1 == 1 || pos[1]+1 == n) {
                    escaped = true;
                    System.out.println("Escaped!");
                }
            }
            toCheck.addAll(tmp);
        }
    }
}
