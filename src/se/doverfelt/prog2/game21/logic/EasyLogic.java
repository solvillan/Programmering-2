package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.gui.components.BaseView;
import se.doverfelt.prog2.game21.gui.views.EasyView;

import java.util.Random;

/**
 * File Name:   EasyLogic.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */
public class EasyLogic implements Logic {

    public EasyView view;
    private int mod;
    private int score;
    private boolean won;
    private Random rand = new Random();

    //Set the current modifier
    @Override
    public void setMod(int mod) {
        this.mod = mod;
    }

    //Init the logic
    @Override
    public void init(BaseView view) {
        if (view instanceof EasyView) {
            this.view = (EasyView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    //Do the player part
    private void doPlayer() {
        score += mod;
        view.label.setText("Computer");
        won = score >= 21;
        view.update();
    }

    //Do the computers choice
    public void doComputer(boolean isFirst) {
        mod = (Math.abs(rand.nextInt() % 2)) + 1;
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
        won = score >= 21;
        view.update();
    }

    //Main logic loop
    @Override
    public void update() {

        doPlayer();

        if (won) return;

        doComputer(false);
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
