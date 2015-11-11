package se.doverfelt.prog2.kap6.uppg6_8;

import se.doverfelt.prog2.kap5.uppg5_8.RandomWord;

import javax.swing.*;

/**
 * Filnamn: Hangman.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-11
 */
public class Hangman extends JFrame {

    public static RandomWord rword;

    public static void main(String[] args) {
        rword = new RandomWord(Hangman.class.getResource("ord.txt").getPath());
        SwingUtilities.invokeLater(Hangman::new);
    }

    public Hangman() {
        System.out.println(rword.randomWord());
    }

}
