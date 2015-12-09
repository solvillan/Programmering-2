package se.doverfelt.prog2.game21.views;

import se.doverfelt.prog2.game21.GameView;

import javax.swing.*;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public class PVPView extends BaseView {

    public PVPView(GameView gameView) {
        super(gameView);
        this.add(new JLabel("Hello, world!"));
    }

    @Override
    public void update() {

    }

    @Override
    public void initialize() {

    }
}
