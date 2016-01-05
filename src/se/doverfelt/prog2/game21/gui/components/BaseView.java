package se.doverfelt.prog2.game21.gui.components;

import se.doverfelt.prog2.game21.logic.Logic;

import javax.swing.*;

/**
 * File Name:   BaseView.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */
public abstract class BaseView extends JPanel implements IView {

    public final GameView gameView;
    public final Logic logic;

    public BaseView(GameView gameView) {
        this.gameView = gameView;
        logic = gameView.game.getLogic();
    }

}
