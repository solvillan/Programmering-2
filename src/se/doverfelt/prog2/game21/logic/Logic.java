package se.doverfelt.prog2.game21.logic;

import se.doverfelt.prog2.game21.gui.components.BaseView;

/**
 * File Name:   Logic.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */
public interface Logic {
    void setMod(int mod);
    void init(BaseView view);
    void update();
    int getScore();
    boolean hasWon();

}
