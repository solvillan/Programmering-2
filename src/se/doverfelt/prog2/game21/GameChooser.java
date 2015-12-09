package se.doverfelt.prog2.game21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rickard.doverfelt on 2015-12-08.
 */
public class GameChooser extends JFrame {

    private JButton easy, hard, pvp;
    private JPanel buttons;
    private Game21 game;

    public GameChooser(Game21 game) {
        this.game = game;

        this.setLayout(new FlowLayout(FlowLayout.TRAILING));

        buttons = new JPanel(new FlowLayout());

        easy = new JButton("Easy computer");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.COMP_EASY);
            GameChooser.this.setVisible(false);
        });
        buttons.add(easy);

        hard = new JButton("Hard computer");
        hard.addActionListener(e -> {
            game.startGame(EnumMode.COMP_HARD);
            this.setVisible(false);
        });
        buttons.add(hard);

        pvp = new JButton("Player vs. Player");
        pvp.addActionListener(e -> {
            game.startGame(EnumMode.PVP);
            this.setVisible(false);
        });
        buttons.add(pvp);

        JLabel splash = null;
        try {
            splash = new JLabel(new ImageIcon(new URL("http", "howtodoinjava.com", "/wp-content/uploads/splash-screen.jpg")));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.add(splash);

        this.add(buttons);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }


}
