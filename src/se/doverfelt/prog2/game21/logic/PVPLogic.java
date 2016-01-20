package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.gui.components.BaseView;
import se.doverfelt.prog2.game21.gui.views.PVPView;

/**
 * File Name:   PVPLogic.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */
public class PVPLogic implements Logic {

    private PVPView view;
    private int score = 0;
    private int mod;
    private boolean won = false;

    //Set the current modifier
    @Override
    public void setMod(int mod) {
        this.mod = mod;
    }

    //Init the logic
    @Override
    public void init(BaseView view) {
        if (view instanceof PVPView) {
            this.view = (PVPView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    //Update the score
    @Override
    public void update() {
        score += mod;

        won = score >= 21;

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
