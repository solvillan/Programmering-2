package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.views.BaseView;
import se.doverfelt.prog2.game21.views.EasyView;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.concurrent.ThreadFactory;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class EasyLogic implements Logic {

    private EasyView view;
    private int mod;
    private int score;
    private boolean won;
    private Random rand = new Random();

    @Override
    public void setMod(int mod) {
        this.mod = mod;
    }

    @Override
    public void init(BaseView view) {
        if (view instanceof EasyView) {
            this.view = (EasyView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    @Override
    public void update() {
        score += mod;
        view.label.setText("Computer");
        view.update();

        mod = (Math.abs(rand.nextInt() % 2)) + 1;
        System.out.println(mod);
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
        score += mod;

        //Do not remove! Updates graphics, should be last call in method
        view.isPlayer = true;
        view.label.setText("Player");
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
