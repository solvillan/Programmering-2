package se.doverfelt.prog2.game21;

import se.doverfelt.prog2.game21.logic.EasyLogic;
import se.doverfelt.prog2.game21.logic.HardLogic;
import se.doverfelt.prog2.game21.logic.Logic;
import se.doverfelt.prog2.game21.logic.PVPLogic;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class Game21 {

    private EnumMode mode;
    private Logic logic;

    public Game21() {
        new GameChooser(this);

    }

    public Logic getLogic() {
        return logic;
    }

    public void startGame(EnumMode mode) {
        this.mode = mode;
        if (mode == EnumMode.COMP_EASY) {
            logic = new EasyLogic();
        } else if (mode == EnumMode.COMP_HARD) {
            logic = new HardLogic();
        } else if (mode == EnumMode.PVP) {
            logic = new PVPLogic();
        }
        new GameView(mode, this);
    }

    public static void main(String[] args) {
        new Game21();
    }

}
