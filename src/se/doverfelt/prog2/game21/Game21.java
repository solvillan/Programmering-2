package se.doverfelt.prog2.game21;

import se.doverfelt.prog2.game21.gui.components.GameView;
import se.doverfelt.prog2.game21.logic.EasyLogic;
import se.doverfelt.prog2.game21.logic.HardLogic;
import se.doverfelt.prog2.game21.logic.Logic;
import se.doverfelt.prog2.game21.logic.PVPLogic;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * File Name:   Game21.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */

public class Game21 {

    private EnumMode mode;
    private Logic logic;
    public GameChooser chooser;

    //Constructor - Init GameChooser
    public Game21() {
        try {
            SwingUtilities.invokeAndWait(() -> chooser = new GameChooser(this));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //Returns current logic
    public Logic getLogic() {
        return logic;
    }

    //Starts the game
    public void startGame(EnumMode mode) {
        this.mode = mode;
        if (mode == EnumMode.COMP_EASY) {
            logic = new EasyLogic();
        } else if (mode == EnumMode.COMP_HARD) {
            logic = new HardLogic();
        } else if (mode == EnumMode.PVP) {
            logic = new PVPLogic();
        }
        GameView gv = new GameView(mode, this);
        logic.init(gv.getMainView());
    }

    public static void main(String[] args) {

        //Set the look and feel to the native one
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Initialize game
        new Game21();
    }

}
