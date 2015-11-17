package se.doverfelt.prog2.kap6.uppg6_8;

import se.doverfelt.prog2.kap5.uppg5_8.RandomWord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Filnamn: Hangman.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-11
 */
public class Hangman extends JFrame {

    public static RandomWord rword;

    public JProgressBar progressBar = new JProgressBar();
    public JTextField input;
    public JTextField word;
    private String guess;
    private ArrayList<Character> correctGuesses;

    public static void main(String[] args) {
        rword = new RandomWord(Hangman.class.getResourceAsStream("ord.txt"));
        SwingUtilities.invokeLater(Hangman::new);
    }

    public void createGUI() {
        this.setTitle("Hangman 1.0");
        GridLayout layout = new GridLayout(3, 1, 10, 5);
        input = new JTextField();
        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                checkLetter(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        input.setFont(new Font("Courier New", Font.PLAIN, 48));
        word = new JTextField();
        word.setFont(new Font("Courier New", Font.PLAIN, 48));
        word.setColumns(15);
        word.setEditable(false);
        layout.addLayoutComponent(null, word);
        this.add(word);
        layout.addLayoutComponent(null, input);
        this.add(input);
        layout.addLayoutComponent(null, progressBar);
        this.add(progressBar);
        this.setLayout(layout);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void checkLetter(char keyChar) {
        input.setText("");
        if (guess.contains("" + keyChar) && !correctGuesses.contains(keyChar)) {
            correctGuesses.add(keyChar);
        } else {
            progressBar.setValue(progressBar.getValue()-1);
        }

        if (progressBar.getValue() <= 0) {
            lose();
            return;
        }
        updateWord();
    }

    private void updateWord() {
        String out = "";
        boolean match = false;
        char[] guessChars = guess.toCharArray();
        for (char guessChar : guessChars) {
            for (char c : correctGuesses) {
                if (guessChar == c) {
                    out += c;
                    match = true;
                }
            }
            if (match) {
                match = false;

            } else {
                out += "*";
            }
        }

        word.setText(out);
        if (out.equals(guess)) {
            win();
        }
    }

    private void win() {
        input.setEditable(false);
        word.setBackground(Color.green);
        word.setForeground(Color.BLACK);
        progressBar.setMaximum(2000);
        progressBar.setValue(0);
        Runnable r = () -> {
            for (int i = 0; i < 2000; i++) {
                progressBar.setValue(i);
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reset();
        };
        Thread t = new Thread(r);
        t.start();
    }

    private void lose() {
        input.setEditable(false);
        word.setBackground(Color.red);
        word.setForeground(Color.BLACK);
        word.setText(guess);
        progressBar.setMaximum(2000);
        progressBar.setValue(0);
        Runnable r = () -> {
            for (int i = 0; i < 2000; i++) {
                progressBar.setValue(i);
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reset();
        };
        Thread t = new Thread(r);
        t.start();
    }

    private void reset() {
        word.setBackground(Color.white);
        word.setForeground(Color.black);
        correctGuesses = new ArrayList<>();
        guess = rword.randomWord();
        String out = "";
        for (int i = 0; i < guess.length(); i++) {
            out += "*";
        }
        word.setText(out);
        progressBar.setMaximum(guess.length());
        progressBar.setValue(guess.length());
        input.setEditable(true);
    }

    public Hangman() {
        createGUI();
        reset();
    }
}
