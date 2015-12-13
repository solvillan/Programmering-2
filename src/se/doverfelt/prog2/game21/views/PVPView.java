package se.doverfelt.prog2.game21.views;

import se.doverfelt.prog2.game21.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public class PVPView extends BaseView {

    private JButton test;

    public PVPView(GameView gameView) {
        super(gameView);
        test = new JButton("Test");
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameView.game.getLogic().update();
            }
        });
        this.add(test);
    }

    @Override
    public void update() {
        test.setText(String.valueOf(logic.getScore()));
    }

    @Override
    public void initialize() {

    }
}
