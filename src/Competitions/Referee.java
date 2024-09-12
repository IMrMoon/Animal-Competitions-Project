package Competitions;


import java.util.concurrent.CountDownLatch;


/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The Referee class is responsible for monitoring a group of animals during a competition.
 * The referee waits for all animals in the group to finish their tasks and then updates the scores.
 * This class implements the Runnable interface, allowing it to be executed in a separate thread.
 */
public class Referee implements Runnable {

    private String groupName; // The name of the group being monitored by this referee
    private Scores scores; // The Scores object used to track the scores of the tournament
    private CountDownLatch latch; // A latch used to synchronize the end of the race for the group

    /**
     * Constructs a Referee with the specified group name, scores object, and latch.
     *
     * @param groupName the name of the group this referee is responsible for.
     * @param scores the Scores object used to track the scores of the tournament.
     * @param latch the CountDownLatch that this referee will wait on.
     */
    public Referee(String groupName, Scores scores, CountDownLatch latch) {
        this.groupName = groupName;
        this.scores = scores;
        this.latch = latch;
    }

    /**
     * The main logic of the referee. The referee waits for all animals in the group to finish their tasks
     * (as indicated by the latch), then updates the scores and notifies all waiting threads that the scores
     * have been updated.
     */
    @Override
    public void run() {
        try {
            System.out.println("Referee for group " + groupName + " waiting for latch to finish...");
            latch.await(); // Wait until all threads in the group have finished
            System.out.println("Latch finished for group " + groupName + ". Adding score...");

            scores.add(groupName); // Add the group name and current time to the scores
            System.out.println("Score added for group: " + groupName);
            System.out.println("Current Scores: " + scores.getAll()); // Print all scores

            synchronized (scores) {
                scores.notifyAll(); // Notify that the scores can be updated
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
