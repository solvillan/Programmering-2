package se.doverfelt.prog2.kap5.uppg5_6;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Filnamn: LengthChecker.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-10-21
 */
public class LengthChecker {

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
        JFileChooser fileChooser = new JFileChooser();
        File inputFile = null, outputFile = null;

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            inputFile = fileChooser.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(null, "No file choosen, exiting...");
            System.exit(404);
        }

        returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            outputFile = fileChooser.getSelectedFile();
            if (!outputFile.exists()) {
                try {
                    outputFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No file choosen, exiting...");
            System.exit(404);
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No such file...");
            System.exit(404);
        }

        String out = "";

        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            int[] measures = new int[3];
            if (scanner.hasNextLine()) {
                Scanner s = new Scanner(scanner.nextLine());
                for (int i = 0; i < measures.length; i++) {
                    if (s.hasNextInt()) {
                        measures[i] = s.nextInt();
                    } else {
                        measures[i] = -1;
                    }
                }
            }
            if (measures[1] >= 200) {
                out += data + "\n" + measures[0] + " " + measures[1] + " " + measures[2] + "\n";
            }
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(out);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Done!");

    }

}
