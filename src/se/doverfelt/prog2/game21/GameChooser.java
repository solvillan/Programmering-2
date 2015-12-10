package se.doverfelt.prog2.game21;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rickard.doverfelt on 2015-12-08.
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
            splash = new ImageIcon(new URL("http", "hdwallpapershub.net", "/wallpapers/m/112/dice_monochrome_m111508.jpg"));
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

        this.setLayout(new FlowLayout());

        easy = new JButton("Easy computer");
        easy.addActionListener(e -> {
            game.startGame(EnumMode.COMP_EASY);
            GameChooser.this.setVisible(false);
        });
        this.add(easy);

        hard = new JButton("Hard computer");
        hard.addActionListener(e -> {
            game.startGame(EnumMode.COMP_HARD);
            this.setVisible(false);
        });
        this.add(hard);

        pvp = new JButton("Player vs. Player");
        pvp.addActionListener(e -> {
            game.startGame(EnumMode.PVP);
            this.setVisible(false);
        });
        this.add(pvp);

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
