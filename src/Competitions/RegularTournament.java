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
 * The RegularTournament class represents a standard tournament where multiple groups of animals compete.
 * This class extends the abstract Tournament class and implements the setup method to prepare the competition.
 */
public class RegularTournament extends Tournament{

    /**
     * Constructs a RegularTournament with the specified animal groups, competition panel, and scores.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing.
     * @param competitionPanel the panel where the competition will be displayed.
     * @param scores the Scores object used to track the scores of the tournament.
     */
    public RegularTournament(List<List<Animal>> animalGroups, CompetitionPanel competitionPanel, Scores scores) {
        super(animalGroups, competitionPanel, scores);
    }

    /**
     * Sets up the tournament by initializing the necessary threads for each animal in the groups and
     * starting the competition.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing.
     */
    @Override
    public void setup(List<List<Animal>> animalGroups) {
        AtomicBoolean startFlag = new AtomicBoolean(false); // Flag to indicate when the race should start
        CountDownLatch latch = new CountDownLatch(1); // Latch to synchronize the end of the race for multiple animals

        // Iterate over each group of animals
        for (List<Animal> animals : animalGroups) {
            double totalDistance = determineTotalDistance(animals.getFirst().getAnimalType());
            // Start a thread for each animal in the group
            for (Animal animal : animals) {
                AtomicBoolean finishFlag = new AtomicBoolean(false);
                AnimalThread animalThread = new AnimalThread(animal, totalDistance, startFlag, finishFlag, latch);
                new Thread(animalThread).start();
            }
            // Start a referee thread for the group
            Referee referee = new Referee(animals.getFirst().getAnimalName(), scores, latch);
            new Thread(referee).start();
        }
        // Initialize and start the tournament thread
        tournamentThread = new TournamentThread(scores,startFlag,animalGroups.size());
        ScoreKeeper.initialize(tournamentThread);

        new Thread(tournamentThread).start();
    }
}

