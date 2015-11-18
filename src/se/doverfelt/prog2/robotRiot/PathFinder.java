package se.doverfelt.prog2.robotRiot;

import java.util.ArrayList;

/**
 * Filnamn: PathFinder.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-18
 */
public class PathFinder implements Runnable {

    private static int x, y, n, m;
    private static EnumTile[][] tiles;
    private ArrayList<String> checked = new ArrayList<>() , toCheck = new ArrayList<>();
    public boolean escaped = false;
    public Thread t;

    public PathFinder(EnumTile[][] tilesOrig, int xIn, int yIn, int nIn, int mIn) {
        tiles = tilesOrig;
        x = xIn;
        y = yIn;
        n = nIn;
        m = mIn;
        t = new Thread(this, "Pathfinder-"+x+";"+y);
        placeCheckPos(x, y);
    }

    private static int[] parsePos(String pos) {
        String[] positions = pos.split(";");
        return new int[]{Integer.parseInt(positions[0]), Integer.parseInt(positions[1])};
    }

    private void placeCheckPos(int x, int y) {
        toCheck.add(x+";"+y);
    }

    @Override
    public void run() {
        while (!escaped && !toCheck.isEmpty()) {
            ArrayList<String> tmp = new ArrayList<>();
            for (String s : toCheck) {
                checked.add(s);
                int [] pos = parsePos(s);
                if (pos[0]-1 >= 0) {
                    if ((tiles[pos[0]-1][pos[1]] == EnumTile.FLOOR || tiles[pos[0]-1][pos[1]] == EnumTile.ROBOT) && !toCheck.contains((pos[0]-1)+";"+pos[1]) && !checked.contains((pos[0]-1)+";"+pos[1])) {
                        tmp.add((pos[0]-1)+";"+pos[1]);
                    }
                }
                if (pos[0]+1 <= n-1) {
                    if ((tiles[pos[0]+1][pos[1]] == EnumTile.FLOOR || tiles[pos[0]+1][pos[1]] == EnumTile.ROBOT) && !toCheck.contains((pos[0]+1)+";"+pos[1]) && !checked.contains((pos[0]+1)+";"+pos[1])) {
                        tmp.add((pos[0]+1)+";"+pos[1]);
                    }
                }
                if (pos[1]-1 >= 0) {
                    if ((tiles[pos[0]][pos[1]-1] == EnumTile.FLOOR || tiles[pos[0]][pos[1]-1] == EnumTile.ROBOT) && !toCheck.contains((pos[0])+";"+(pos[1]-1)) && !checked.contains((pos[0])+";"+(pos[1]-1))) {
                        tmp.add((pos[0])+";"+(pos[1]-1));
                    }
                }
                if (pos[1]+1 <= m-1) {
                    if ((tiles[pos[0]][pos[1]+1] == EnumTile.FLOOR || tiles[pos[0]][pos[1]+1] == EnumTile.ROBOT) && !toCheck.contains((pos[0])+";"+(pos[1]+1)) && !checked.contains((pos[0])+";"+(pos[1]+1))) {
                        tmp.add((pos[0])+";"+(pos[1]+1));
                    }
                }
                if (pos[0]-1 == -1 || pos[0]+1 == m+1 || pos[1]-1 == -1 || pos[1]+1 == n+1) {
                    escaped = true;
                }
            }
            if (!escaped) {
                toCheck = new ArrayList<>(tmp);
            }
        }
    }

    public void start() {
        t.checkAccess();
        t.start();
    }
}
