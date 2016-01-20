package se.doverfelt.prog2.kap7.uppg7_5;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rickard on 2016-01-20.
 */
public class CircleDiagram extends JPanel {

    private int min, max, value;

    public CircleDiagram(int min, int max) {
        if (min < max) {
            this.max = max;
            this.min = min;
            this.value = min;
        }
    }

    public CircleDiagram() {
        this(0, 100);
    }

    public void setValue(int value) {
        if (value < min) {
            this.value = min;
        } else if (value > max) {
            this.value = max;
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

    }
}
