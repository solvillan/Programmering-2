package se.doverfelt.prog2.game21.views;

import se.doverfelt.prog2.game21.GameView;
import se.doverfelt.prog2.game21.logic.Logic;

import javax.swing.*;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public abstract class BaseView extends JPanel implements IView {

    public final GameView gameView;
    public final Logic logic;

    public BaseView(GameView gameView) {
        this.gameView = gameView;
        logic = gameView.game.getLogic();
    }

}
