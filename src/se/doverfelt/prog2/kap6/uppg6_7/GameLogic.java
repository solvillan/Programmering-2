package se.doverfelt.prog2.kap6.uppg6_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * @author Rickard Doverfelt
 *         Datum: 2015-11-10
 *         Filnamn: GameLogic.java
 */
public class GameLogic implements Runnable {
    private RPSGame g;
    private boolean rock, scissors, paper;
    private String choice = "";
    private int games = 0, score = 0;

    public void init(RPSGame g) {
        this.g = g;
    }

    public void buttonPressed(JButton button, ActionEvent event) {
        paper = (button == g.buttons.paper);
        rock = (button == g.buttons.rock);
        scissors = (button == g.buttons.scissors);
    }

    @Override
    public void run() {
        while (RPSGame.running) {
            enableButtons();
            genCompChoice();
            resetText();
            while (!rock && !scissors && !paper) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            disableButtons();
            checkResults();
            rock = false;
            paper = false;
            scissors = false;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void disableButtons() {
        g.buttons.paper.setEnabled(false);
        g.buttons.rock.setEnabled(false);
        g.buttons.scissors.setEnabled(false);
    }

    private void checkResults() {
        g.print("Computer choose " + choice + ".");

        if (rock && choice.equals("scissors")) {
            showWin();
            score++;
            games++;
            g.print("Your rock won against the scissors.");
        } else if (scissors && choice.equals("paper")) {
            showWin();
            score++;
            games++;
            g.print("Your scissors won against the paper.");
        } else if (paper && choice.equals("rock")) {
            showWin();
            score++;
            games++;
            g.print("Your paper won against the rock.");
        } else if ((scissors && choice.equals("scissors")) || (rock && choice.equals("rock")) || (paper && choice.equals("paper"))) {
            showTie();
            g.print("Tie");
        } else {
            showLose();
            games++;
            g.print("You lost against " + choice + ".");
        }


        g.print("You have won " + score + " of " + games + " games.");
        g.progressBar.setMaximum(games);
        g.progressBar.setValue(score);
        g.progressBar.setString("Score " + score + "/" + games);
        if ((double)score/games <= 1d/3d) {
            g.progressBar.setForeground(Color.red);
        } else if ((double)score/games <= 2d/3d && (double)score/games > 1d/3d) {
            g.progressBar.setForeground(Color.orange);
        } else {
            g.progressBar.setForeground(Color.green);
        }
    }

    private void showWin() {
        g.textField.setBackground(Color.green);
        g.textField.setForeground(Color.black);
    }

    private void showLose() {
        g.textField.setBackground(Color.red);
        g.textField.setForeground(Color.black);
    }

    private void showTie() {
        g.textField.setBackground(Color.orange);
        g.textField.setForeground(Color.black);
    }

    private void resetText() {
        g.clear();
        g.textField.setBackground(Color.white);
        g.textField.setForeground(Color.black);
    }


    private void genCompChoice() {
        Random r = new Random();
        switch (r.nextInt(3)) {
            case 0:
                choice = "rock";
                break;
            case 1:
                choice = "paper";
                break;
            case 2:
                choice = "scissors";
                break;
            default:
                choice="Nope";
                break;
        }

    }

    private void enableButtons() {
        g.buttons.paper.setEnabled(true);
        g.buttons.rock.setEnabled(true);
        g.buttons.scissors.setEnabled(true);
    }
}
