package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.views.BaseView;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public interface Logic {
    void setMod(int mod);
    void init(BaseView view);
    void update();
    int getScore();
    boolean hasWon();

}
