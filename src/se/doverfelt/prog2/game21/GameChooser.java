package se.doverfelt.prog2.game21;

import se.doverfelt.prog2.game21.gui.components.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * File Name:   GameChooser.java
 * Author:      Rickard Doverfelt
 * Class:       TE21 / TI2
 */

public class GameChooser extends JFrame {

    private JButton easy, hard, pvp;
    private Game21 game;
    private ImageIcon splash;
    private Point point = new Point();

    public GameChooser(Game21 game) {
        this.setUndecorated(true);
        this.game = game;
        try {
            splash = new ImageIcon(new URL("http", "www.psdgraphics.com", "/wp-content/uploads/2015/06/mosaic-background.png"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.setContentPane(new JLabel(splash));

        GameChooser gameChooser = this;
        gameChooser.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        gameChooser.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = gameChooser.getLocation();
                gameChooser.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });

        this.setLayout(new GridLayout(5, 3));
        for (int i = 0; i < 15; i++) {
            this.add(new JLabel(""), i);
        }

        MenuButton quit = new MenuButton("Quit");
        quit.setForeground(new Color(72, 72, 72));
        quit.setRightAligned(true);
        quit.addActionListener(e -> System.exit(0));
        this.add(quit, 3);

        easy = new MenuButton("Easy computer");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.COMP_EASY);
            GameChooser.this.setVisible(false);
        });
        this.add(easy, 8);

        hard = new MenuButton("Hard computer");
        hard.addActionListener(e -> {
            game.startGame(EnumMode.COMP_HARD);
            this.setVisible(false);
        });
        this.add(hard, 12);

        pvp = new MenuButton("PVP");
        pvp.addActionListener(e -> {
            game.startGame(EnumMode.PVP);
            this.setVisible(false);
        });
        this.add(pvp, 16);

        this.setSize(splash.getIconWidth(), splash.getIconHeight());
        this.repaint();
        Thread t = new Thread(() -> {
            while (true) {
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
