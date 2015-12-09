package se.doverfelt.prog2.game21;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class GameView {

    private EnumMode mode;

    public GameView(EnumMode mode) {
        this.mode = mode;
        if (mode != EnumMode.PVP) {
            initPVCWindow();
        } else {
            initPVPWindow();
        }
    }

    private void initPVPWindow() {

    }

    private void initPVCWindow() {

    }

}
