package se.doverfelt.prog2.game21;

import se.doverfelt.prog2.game21.views.BaseView;
import se.doverfelt.prog2.game21.views.EasyView;
import se.doverfelt.prog2.game21.views.HardView;
import se.doverfelt.prog2.game21.views.PVPView;

import javax.swing.*;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class GameView extends JFrame{

    private EnumMode mode;
    private BaseView mainView;
    public Game21 game;

    public GameView(EnumMode mode, Game21 game21) {
        this.mode = mode;
        this.game = game21;
        if (mode != EnumMode.PVP) {
            initPVCWindow(mode);
        } else {
            initPVPWindow();
        }
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public BaseView getMainView() {
        return mainView;
    }

    private void initPVPWindow() {
        mainView = new PVPView(this);
        this.add(mainView);
        this.pack();
        this.setVisible(true);
    }

    private void initPVCWindow(EnumMode mode) {
        mainView = mode == EnumMode.COMP_EASY ? new EasyView(this) : new HardView(this);
        this.add(mainView);
        this.pack();
        this.setVisible(true);
    }

}
