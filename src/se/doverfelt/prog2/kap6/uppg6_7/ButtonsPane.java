package se.doverfelt.prog2.kap6.uppg6_7;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rickard Doverfelt
 *         Datum: 2015-11-08
 *         Filnamn: ButtonsPane.java
 */
public class ButtonsPane extends JPanel {

    public JButton rock, paper, scissors;

    public ButtonsPane() {
        rock = new JButton("Rock");
        paper = new JButton("Paper");
        scissors = new JButton("Scissors");
        this.setLayout(new FlowLayout());
        this.add(rock);
        this.add(paper);
        this.add(scissors);
        this.setVisible(true);
    }

}
