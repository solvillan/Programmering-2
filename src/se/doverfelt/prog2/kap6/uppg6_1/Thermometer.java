package se.doverfelt.prog2.kap6.uppg6_1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Filnamn: Thermometer.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-04
 */
public class Thermometer extends JFrame {

    private JLabel celsiusTxt, fahrenheitTxt;
    private JSlider celsius, fahrenheit;
    private boolean changed = false;

    public static void main(String[] args) {
        new Thermometer();
    }

    public int faherheitToCelsius(int f) {
        return (f-32)*5/9;
    }

    public int celsiusToFahrenheit(int c) {
        return c*9/5+32;
    }


    public Thermometer() {
        celsius = new JSlider(JSlider.VERTICAL, 0, 300, faherheitToCelsius(32));
        fahrenheit = new JSlider(JSlider.VERTICAL, 0, 300, 32);
        celsiusTxt = new JLabel(faherheitToCelsius(32) + "C");
        fahrenheitTxt = new JLabel("32F");

        fahrenheit.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (fahrenheit.getValue() < 300) {
                    fahrenheitTxt.setText(fahrenheit.getValue() + "F");
                } else {
                    fahrenheitTxt.setText(celsiusToFahrenheit(celsius.getValue()) + "F");
                }
                if (changed) {
                    changed = false;
                    return;
                }
                changed = true;
                celsius.setValue(faherheitToCelsius(fahrenheit.getValue()));

                System.out.println("f: " + fahrenheit.getValue() + " c: " + celsius.getValue());
            }
        });

        celsius.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (fahrenheit.getValue() < 300) {
                    fahrenheitTxt.setText(fahrenheit.getValue() + "F");
                } else {
                    fahrenheitTxt.setText(celsiusToFahrenheit(celsius.getValue()) + "F");
                }
                if (celsius.getValue() > 0) {
                    celsiusTxt.setText(celsius.getValue() + "C");
                } else {
                    celsiusTxt.setText("< 0C");
                }

                if (changed) {
                    changed = false;
                    return;
                }
                changed = true;
                fahrenheit.setValue(celsiusToFahrenheit(celsius.getValue()));
                System.out.println("f: " + fahrenheit.getValue() + " c: " + celsius.getValue());
            }
        });

        this.setLayout(new GridLayout(1, 2, 10, 20));
        JPanel f, c;

        c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.add(new JLabel("Celsius"));
        c.add(celsius);
        c.add(celsiusTxt);

        f = new JPanel();
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
        f.add(new JLabel("Fahrenheit"));
        f.add(fahrenheit);
        f.add(fahrenheitTxt);

        this.add(c);
        this.add(f);

        this.pack();
        this.setSize(this.getWidth() + 20, this.getHeight() + 20);
        this.setEnabled(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
