package Animals;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.sleep;

/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The AnimalThread class represents a runnable thread for an animal participating in a race or competition.
 * This class handles the movement of the animal and manages its progress towards a finish line,
 * taking into account the animal's speed, size, and energy level.
 */

public class AnimalThread implements Runnable{

    private static final int SLEEP_TIME = 100; // The sleep time in milliseconds between each movement
    private Animal participant; // The animal participating in the race
    private double neededDistance; // The distance required to reach the finish line
    private double distanceTraveled; // The distance the animal has traveled so far
    private AtomicBoolean startFlag; // Flag to indicate when the race starts
    private AtomicBoolean finishFlag; // Flag to indicate when the race is finished
    private CountDownLatch latch; // Latch to synchronize the end of the race for multiple animals


    /**
     * Constructs an AnimalThread with the specified parameters.
     *
     * @param participant the animal participating in the race.
     * @param neededDistance the distance the animal needs to travel to finish.
     * @param startFlag an atomic boolean flag that indicates when the race should start.
     * @param finishFlag an atomic boolean flag that indicates when the race has finished.
     * @param latch a CountDownLatch used to synchronize the completion of the race.
     */

    public AnimalThread(Animal participant, double neededDistance, AtomicBoolean startFlag, AtomicBoolean finishFlag, CountDownLatch latch){
        this.participant = participant;
        this.startFlag = startFlag;
        this.finishFlag = finishFlag;
        this.neededDistance = neededDistance;
        this.distanceTraveled = 0;
        this.latch = latch;
    }


    /**
     * The main logic of the thread. Waits for the start signal and then moves the animal towards the finish line.
     * The animal continues to move until it reaches the finish line or runs out of energy.
     */
    @Override
    public void run() {
        synchronized (startFlag) {
            while (!startFlag.get()) {
                try {
                    System.out.println("Animal " + participant + " is Waiting for startFlag");
                    startFlag.wait();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Animal " + participant + " is interrupted");
                }
            }
        }

        while (true) {

            // Check if the animal has reached the finish line or has no energy left
            if (distanceTraveled >= neededDistance - (participant.getSize() * 2) - participant.getSpeed() || participant.getEnergyLevel() <= 0) {
                break; // יציאה אם החיה הגיעה לקו הסיום או שנגמרה לה האנרגיה
            }

            synchronized (participant) {
                // Move the animal and update the distance traveled
                participant.move();
                distanceTraveled += participant.getSpeed();
                System.out.println("Animal: " + participant.getAnimalName() + " Moved " + distanceTraveled);
            }


            // If the animal has finished, notify all waiting threads
            if (distanceTraveled >= neededDistance - (participant.getSize() * 2)-participant.getSpeed()) {
                 synchronized (finishFlag) {
                     finishFlag.set(true);
                     finishFlag.notifyAll();// התראה לסיום התהליך
                 }
                 System.out.println("Animal " + participant + " has finished");
                 latch.countDown();
                 break;
             } else if (participant.getEnergyLevel() <= 0) {
                 System.out.println("Animal " + participant + " has no energy level");
             }

            // Repaint the panel to reflect the new position of the animal
            participant.pan.repaint();

             try {
                 Thread.sleep(SLEEP_TIME);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }
}

