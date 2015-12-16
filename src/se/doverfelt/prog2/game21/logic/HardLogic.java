package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.views.BaseView;
import se.doverfelt.prog2.game21.views.HardView;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class HardLogic implements Logic {

    private HardView view;

    @Override
    public void setMod(int mod) {

    }

    @Override
    public void init(BaseView view) {
        if (view instanceof HardView) {
            this.view = (HardView) view;
        } else {
            System.err.println("Something impossible happened...");
            System.exit(-101);
        }
    }

    @Override
    public void update() {

        //Do not remove! Updates graphics, should be last call in method
        view.update();
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public boolean hasWon() {
        return false;
    }
}
