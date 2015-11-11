package se.doverfelt.prog2.kap6.uppg6_7;

import javax.swing.*;
import java.awt.*;

/**
 * @author Rickard Doverfelt
 *         Datum: 2015-11-08
 *         Filnamn: RPSGame.java
 */
public class RPSGame extends JFrame {

    public JProgressBar progressBar;
    public JTextArea textField;
    public static boolean running = true;
    public static RPSGame instance;
    public ButtonsPane buttons;
    public GameLogic g;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> instance = new RPSGame()); //new RPSGame();
    }

    private void createGUI() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        progressBar = new JProgressBar(JProgressBar.VERTICAL);
        progressBar.setMaximum(0);
        progressBar.setMinimum(0);
        progressBar.setStringPainted(true);
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.weightx = 0.25;
        c.weighty = 1;
        c.gridy = 0;
        c.gridheight = 2;
        layout.setConstraints(progressBar, c);
        this.add(progressBar);

        textField = new JTextArea();
        textField.setColumns(40);
        textField.setRows(6);
        textField.setEditable(false);
        JScrollPane spane = new JScrollPane(textField);
        spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        spane.setAutoscrolls(true);
        c.insets = new Insets(10, 0, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 1;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0.5;
        c.ipadx = 40;
        layout.setConstraints(spane, c);
        this.add(spane);

        buttons = new ButtonsPane();
        buttons.setVisible(true);
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 0.1;
        layout.setConstraints(buttons, c);
        this.add(buttons);

        this.pack();
        this.setVisible(true);
        this.setEnabled(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public RPSGame() {
        createGUI();
        createListeners();
        g = new GameLogic();
        g.init(this);
        Thread t = new Thread(g);
        t.start();
    }

    public void print(String s) {
        textField.append(s + "\n");
        textField.setCaretPosition(textField.getDocument().getLength());
    }

    private void createListeners() {
        buttons.paper.addActionListener(e -> {
            g.buttonPressed(buttons.paper, e);
            print("You choose paper.");
        });
        buttons.rock.addActionListener(e -> {
            g.buttonPressed(buttons.rock, e);
            print("You choose rock.");
        });
        buttons.scissors.addActionListener(e -> {
            g.buttonPressed(buttons.scissors, e);
            print("You choose scissors.");
        });
    }

    public void clear() {
        textField.setText("");
    }
}
