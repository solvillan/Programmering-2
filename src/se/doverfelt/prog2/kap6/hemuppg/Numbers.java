package se.doverfelt.prog2.kap6.hemuppg;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Filnamn: Numbers.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-11-11
 */
public class Numbers extends JFrame {

    private static FileInputStream inFile;

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
        try {
            inFile = new FileInputStream(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(Numbers::new);
    }

    public Numbers() {
        this.setLayout(new FlowLayout());
        ListPane less = new ListPane();
        ListPane more = new ListPane();

        Scanner s = new Scanner(inFile);
        while (s.hasNextInt()) {
            int i = s.nextInt();
            if (i < 100) {
                less.add(i);
            } else {
                more.add(i);
            }
        }
        this.add(less);
        this.add(more);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
