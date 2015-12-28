package se.doverfelt.prog2.game21.views;

import se.doverfelt.prog2.game21.GameView;
import se.doverfelt.prog2.game21.logic.HardLogic;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by rickard.doverfelt on 2015-12-09.
 */
public class HardView extends BaseView {
    public final JLabel label = new JLabel("Player");
    private JProgressBar progress;
    public JButton p11, p12;
    public boolean isPlayer = true;
    private SwingWorker updater;

    public HardView(GameView gameView) {
        super(gameView);

        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);

        updater = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                logic.update();
                return null;
            }
        };

        JPanel buttons = new JPanel(new GridLayout(3, 1));

        p11 = new JButton("+1");
        p11.addActionListener(e -> {
            isPlayer = false;
            logic.setMod(1);
            updater.execute();
        });


        p12 = new JButton("+2");
        p12.addActionListener(e -> {
            isPlayer = false;
            logic.setMod(2);
            updater.execute();
        });


        // Player 1
        buttons.add(label);
        buttons.add(p11);
        buttons.add(p12);

        //ProgressBar
        progress = new JProgressBar(0, 21);
        progress.setSize(this.getWidth(), (int) (this.getHeight()*0.2f));
        progress.setStringPainted(true);
        progress.setString("0");
        this.add(progress, BorderLayout.NORTH);

        // Buttons
        this.add(buttons, BorderLayout.CENTER);

        ((HardLogic)logic).view = this;

        Random rand = new Random();
        if ((Math.abs(rand.nextInt() % 2)) == 1) {
            ((HardLogic)logic).doComputer(true);
        }

    }

    @Override
    public void update() {
        System.out.println("UPDATE! " + isPlayer);
        SwingUtilities.invokeLater(() -> p11.setEnabled(isPlayer));
        SwingUtilities.invokeLater(() -> p12.setEnabled(isPlayer));
        progress.setValue(logic.getScore());
        progress.setString("" + logic.getScore());
        if (logic.hasWon()) {
            String winner = !isPlayer ? "You" : "The Computer";
            JOptionPane.showMessageDialog(this, winner + " won!");
            gameView.game.chooser.setVisible(true);
            gameView.dispose();
        }
        updater = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                logic.update();
                return null;
            }
        };
    }

    @Override
    public void initialize() {

    }
}
