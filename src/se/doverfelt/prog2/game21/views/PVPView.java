package se.doverfelt.prog2.game21.views;

import se.doverfelt.prog2.game21.GameView;
import se.doverfelt.prog2.game21.logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public class PVPView extends BaseView {

    private JProgressBar progress;
    private JButton p11, p12, p21, p22;
    private boolean isPlayer1 = true;

    public PVPView(GameView gameView) {
        super(gameView);

        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        JPanel buttons = new JPanel(new GridLayout(3, 2));

        p11 = new JButton("+1");
        p11.addActionListener(e -> {
            isPlayer1 = false;
            logic.setMod(1);
            logic.update();
        });


        p12 = new JButton("+2");
        p12.addActionListener(e -> {
            isPlayer1 = false;
            logic.setMod(2);
            logic.update();
        });



        p21 = new JButton("+1");
        p21.addActionListener(e -> {
            isPlayer1 = true;
            logic.setMod(1);
            logic.update();
        });
        p21.setEnabled(false);

        p22 = new JButton("+2");
        p22.addActionListener(e -> {
            isPlayer1 = true;
            logic.setMod(2);
            logic.update();
        });
        p22.setEnabled(false);


        // Player 1
        buttons.add(new JLabel("Player 1"), 0);
        //Player 2
        buttons.add(new JLabel("Player 2"), 1);
        buttons.add(p11);
        buttons.add(p21);
        buttons.add(p12);
        buttons.add(p22);

        //ProgressBar
        progress = new JProgressBar(0, 21);
        progress.setSize(this.getWidth(), (int) (this.getHeight()*0.2f));
        progress.setStringPainted(true);
        progress.setString("0");
        this.add(progress, BorderLayout.NORTH);

        // Buttons
        this.add(buttons, BorderLayout.CENTER);


    }

    @Override
    public void update() {
        p11.setEnabled(isPlayer1);
        p12.setEnabled(isPlayer1);
        p21.setEnabled(!isPlayer1);
        p22.setEnabled(!isPlayer1);
        progress.setValue(logic.getScore());
        progress.setString("" + logic.getScore());
        if (logic.hasWon()) {
            String winner = !isPlayer1 ? "Player 1" : "Player 2";
            JOptionPane.showMessageDialog(this, winner + " won!");
            gameView.game.chooser.setVisible(true);
            gameView.dispose();
        }
    }

    @Override
    public void initialize() {

    }
}
