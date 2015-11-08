package se.doverfelt.prog2.kap6.uppg6_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Filnamn: ImageSwitcher.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-04
 */
public class ImageSwitcher extends JFrame {

    public static JLabel image;
    private JButton change = new JButton("Change");
    private ImageIcon google, twitter;

    public static void main(String[] args) {
        try {
            new ImageSwitcher();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public ImageSwitcher() throws MalformedURLException {
        twitter = new ImageIcon(new URL("https://pbs.twimg.com/profile_images/615680132565504000/EIpgSD2K.png"));
        google = new ImageIcon(new URL("https://pbs.twimg.com/profile_images/638751551457103872/KN-NzuRl.png"));
        image = new JLabel(google);
        image.setSize(512, 512);
        this.setLayout(new FlowLayout());
        this.add(image);
        change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image.getIcon().equals(google)) {
                    image.setIcon(twitter);
                } else {
                    image.setIcon(google);
                }
            }
        });
        this.add(change);

        this.pack();
        this.setVisible(true);
        this.setEnabled(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
