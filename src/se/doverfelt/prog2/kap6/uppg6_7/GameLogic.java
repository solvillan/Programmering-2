package se.doverfelt.prog2.kap6.uppg6_7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * Created by Rickard on 2015-11-10.
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
            g.clear();
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
                Thread.sleep(1000);
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
        g.print(choice);
        games++;
        if (rock && choice.equals("scissors")) {
            score++;
        } else if (scissors && choice.equals("paper")) {
            score++;
        } else if (paper && choice.equals("rock")) {
            score++;
        }


        g.print("You have won " + score + " of " + games + " games.");
        g.progressBar.setMaximum(games);
        g.progressBar.setValue(score);
    }

    private void genCompChoice() {
        Random r = new Random();
        switch (r.nextInt(3)) {
            case 1:
                choice = "rock";
                break;
            case 2:
                choice = "paper";
                break;
            case 3:
                choice = "scissors";
                break;
            default:
                break;
        }

    }

    private void enableButtons() {
        g.buttons.paper.setEnabled(true);
        g.buttons.rock.setEnabled(true);
        g.buttons.scissors.setEnabled(true);
    }
}
