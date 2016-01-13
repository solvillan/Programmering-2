package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.gui.components.BaseView;
import se.doverfelt.prog2.game21.gui.views.HardView;

import java.util.Random;

/**
 * File Name:   HardLogic.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */
public class HardLogic implements Logic {

    public HardView view;
    private int mod;
    private int score;
    private boolean won;

    //Set current modifier
    @Override
    public void setMod(int mod) {
        this.mod = mod;
    }

    //Init the logic
    @Override
    public void init(BaseView view) {
        if (view instanceof HardView) {
            this.view = (HardView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    // Process the players choice
    private void doPlayer() {
        score += mod;
        view.label.setText("Computer");
        won = score >= 21;
        view.update();
    }

    //Computer algorithm
    public void doComputer(boolean isFirst) {
        //Decide the best choice
        if (score % 3 == 1) {
            mod = 2;
        } else if (score % 3 == 2) {
            mod = 1;
        } else {
            mod = 1;
        }

        System.out.println(mod);

        if (!isFirst) {
            if (mod == 1) {
                view.p11.setEnabled(true);
            } else {
                view.p12.setEnabled(true);
            }
            view.repaint();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.p11.setEnabled(false);
            view.p12.setEnabled(false);
            view.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.isPlayer = true;
            view.label.setText("Player");
        }
        score += mod;
    }

    //Main logic loop
    @Override
    public void update() {

        doPlayer();

        if (won) return;

        doComputer(false);

        //Do not remove! Updates graphics, should be last call in method
        won = score >= 21;
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
