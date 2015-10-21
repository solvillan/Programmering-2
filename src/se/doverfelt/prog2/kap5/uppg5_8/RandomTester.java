package se.doverfelt.prog2.kap5.uppg5_8;

import javax.swing.*;

/**
 * Filnamn: RandomTester.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-10-21
 */
public class RandomTester {
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
        String inputFile = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(null, "No file choosen, exiting...");
            System.exit(404);
        }
        RandomWord randomWord = new RandomWord(inputFile);
        for (int i = 0; i < 10; i++) {
            System.out.println(randomWord.randomWord());
        }
    }
}
