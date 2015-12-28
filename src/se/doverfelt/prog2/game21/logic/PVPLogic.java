package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.gui.components.BaseView;
import se.doverfelt.prog2.game21.gui.views.PVPView;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class PVPLogic implements Logic {

    private PVPView view;
    private int score = 0;
    private int mod;
    private boolean won = false;

    @Override
    public void setMod(int mod) {
        this.mod = mod;
    }

    @Override
    public void init(BaseView view) {
        if (view instanceof PVPView) {
            this.view = (PVPView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    @Override
    public void update() {
        score += mod;

        won = score == 21;

        //Do not remove! Updates graphics, should be last call in method
        view.update();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean hasWon() {
        return won;
    }
}
