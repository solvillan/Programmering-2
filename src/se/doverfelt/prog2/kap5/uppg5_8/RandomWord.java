package se.doverfelt.prog2.kap5.uppg5_8;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Filnamn: RandomWord.java
 *
 * @author Rickard Doverfelt
 *         Datum: 2015-10-21
 */
public class RandomWord {

    private ArrayList<String> words = new ArrayList<>();

    public RandomWord(String path) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "File does not exist...");
            System.exit(404);
        }
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
    }

    public RandomWord(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            words.add(scanner.nextLine());
        }
    }

    public String randomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }

}
