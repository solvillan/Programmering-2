package se.doverfelt.prog2.game21;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class GameChooser extends JFrame {

    private JButton easy, hard, pvp;
    private Game21 game;

    public GameChooser(Game21 game) {
        this.game = game;

        this.setLayout(new FlowLayout());

        easy = new JButton("Easy computer");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.COMP_EASY);
            this.setVisible(false);
        });
        this.add(easy);

        hard = new JButton("Hard computer");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.COMP_HARD);
            this.setVisible(false);
        });
        this.add(hard);

        pvp = new JButton("Player vs. Player");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.PVP);
            this.setVisible(false);
        });
        this.add(pvp);

        this.pack();
        this.setVisible(true);

    }


}
