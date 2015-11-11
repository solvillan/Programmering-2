package se.doverfelt.prog2.kap6.hemuppg;

import javax.swing.*;
import java.awt.*;

/**
 * Filnamn: ListPane.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-11
 */
public class ListPane extends JPanel {

    public JList<Integer> list;
    public JLabel length, mean;
    private DefaultListModel<Integer> lm = new DefaultListModel<>();
    private int total;

    public ListPane() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        list = new JList<>(lm);
        mean = new JLabel("Mean: " + 0);
        length = new JLabel("Amount: " + lm.size());

        JPanel labels = new JPanel(new FlowLayout());
        labels.add(length);
        labels.add(mean);

        this.add(list);
        this.add(labels);
    }

    public void add(int value) {
        total += value;
        lm.addElement(value);
        if (lm.size() != 0) {
            double meanVal = total/lm.size();
            mean.setText("Mean: " + meanVal);
            length.setText("Amount: " + lm.size());
        }
    }

    public void updateCalcs() {
        if (lm.size() != 0) {
            double meanVal = total/lm.size();
            mean.setText("Mean: " + meanVal);
            length.setText("Amount: " + lm.size());
        }
    }

}
