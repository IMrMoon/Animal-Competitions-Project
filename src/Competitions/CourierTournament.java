package Competitions;

import Animals.Animal;
import Animals.AnimalThread;
import Graphics.CompetitionPanel;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The CourierTournament class represents a courier-style tournament where animals compete in relay races.
 * This class extends the abstract Tournament class and implements the setup method to prepare the competition.
 */
public class CourierTournament extends Tournament {


    /**
     * Constructs a CourierTournament with the specified animal groups, competition panel, and scores.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing in a relay.
     * @param competitionPanel the panel where the competition will be displayed.
     * @param scores the Scores object used to track the scores of the tournament.
     */
    public CourierTournament(List<List<Animal>> animalGroups, CompetitionPanel competitionPanel, Scores scores) {
        super(animalGroups, competitionPanel, scores);
    }

    /**
     * Sets up the courier tournament by initializing the necessary threads for each animal in the groups
     * and starting the competition. Each animal in a group runs a portion of the total distance in a relay format.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing in a relay.
     */
    @Override
    public void setup(List<List<Animal>> animalGroups) {
        AtomicBoolean startFlag = new AtomicBoolean(false); // Flag to indicate when the race should start


        // Iterate over each group of animals
        for (List<Animal> group : animalGroups) {
            int groupSize = group.size();
            AtomicBoolean[] flags = new AtomicBoolean[groupSize]; // Flags to signal between animals in the relay
            CountDownLatch latch = new CountDownLatch(groupSize); // Latch to synchronize the end of the relay

            double totalDistance = determineTotalDistance(group.get(0).getAnimalType()); // Determine the race distance

            // Start a thread for each animal in the relay group
            for (int i = 0; i < groupSize; i++) {
                flags[i] = new AtomicBoolean(false);
                AnimalThread animalThread;
                if (i == 0) {
                    // The first animal in the relay starts based on the startFlag
                    animalThread = new AnimalThread(group.get(i), (totalDistance / groupSize), startFlag, flags[0], latch);
                } else {
                    // Subsequent animals start based on the previous animal's finishFlag
                    animalThread = new AnimalThread(group.get(i), (totalDistance / groupSize), flags[i - 1], flags[i], latch);
                }
                new Thread(animalThread).start();
            }
            // Start a referee thread for the group
            Referee referee = new Referee(group.get(groupSize - 1).getGroupName(), scores, latch);
            new Thread(referee).start();
        }
        // Initialize and start the tournament thread
        tournamentThread = new TournamentThread(scores, startFlag, animalGroups.size());
        ScoreKeeper.initialize(tournamentThread);
        new Thread(tournamentThread).start();
    }
}

