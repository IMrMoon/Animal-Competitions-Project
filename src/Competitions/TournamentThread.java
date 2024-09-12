package Competitions;

import Animals.Animal;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 *  * Segev Chen 322433400
 *  * Yinon Alfasi 208810374
 * The TournamentThread class is responsible for coordinating the start and end of a tournament,
 * tracking the progress of competing groups, and managing the final scores. This class implements
 * the Runnable interface, allowing it to be executed in a separate thread.
 */
public class TournamentThread implements Runnable{

    private Scores scores; // Holds final results of each group
    private AtomicBoolean startSignal; // A special flag to initialize all animals
    private int groups; // Number of the competing groups


    /**
     * Constructs a TournamentThread with the specified scores, start signal, and number of groups.
     *
     * @param scores the Scores object that holds the final results of each group.
     * @param startSignal an AtomicBoolean used to signal the start of the tournament.
     * @param groups the number of competing groups in the tournament.
     */
    public TournamentThread(Scores scores, AtomicBoolean startSignal, int groups) {
        this.scores = scores;
        this.startSignal = startSignal;
        this.groups = groups;
    }

    /**
     * The main logic of the tournament thread. This method starts the tournament by signaling
     * the start flag, waits for all groups to finish, and then outputs the final scores.
     */
    @Override
    public void run() {
        // Signal all animal threads to start the race
        synchronized (startSignal) {
            startSignal.set(true);
            startSignal.notifyAll();
        }

        int numOfFinishedGroups = 0;
        // Wait for all groups to finish
        while (numOfFinishedGroups < groups) {
            synchronized (scores) {
                try {
                    scores.wait(); // Wait until a group finishes
                    numOfFinishedGroups++;
                    System.out.println("Group finished. Number of finished groups: " + numOfFinishedGroups);
                    System.out.println("Current Scores: " + scores.getAll());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // All groups have finished, print the final scores
        System.out.println("All groups finished. Final Scores:");
        synchronized (scores) {
            scores.notifyAll(); // Notify any waiting threads that the tournament is complete
            System.out.println(scores.getAll());

        }
    }


    /**
     * Returns the Scores object associated with this tournament thread.
     *
     * @return the Scores object containing the final results of the tournament.
     */
    public Scores getScores() {
        return scores;
    }
}

