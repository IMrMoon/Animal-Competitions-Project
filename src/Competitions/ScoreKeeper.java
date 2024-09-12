package Competitions;

import Competitions.Scores;
import Competitions.TournamentThread;

/**
 * The ScoreKeeper class is responsible for managing and retrieving the scores of a tournament.
 * It interacts with the TournamentThread to obtain the current scores and provides a static
 * interface to access these scores.
 */
public class ScoreKeeper {
    private static TournamentThread tournamentThread; // The thread managing the overall tournament

    /**
     * Initializes the ScoreKeeper with the specified TournamentThread.
     * This method must be called before attempting to retrieve scores.
     *
     * @param thread the TournamentThread that manages the tournament.
     */
    public static void initialize(TournamentThread thread) {
        tournamentThread = thread;
    }

    /**
     * Retrieves the current scores from the TournamentThread.
     *
     * @return the current Scores object from the tournament.
     * @throws IllegalStateException if the TournamentThread has not been initialized.
     */
    public static Scores getScores() {
        if (tournamentThread == null) {
            throw new IllegalStateException("TournamentThread has not been initialized.");
        }
        Scores currentScores = tournamentThread.getScores();
        System.out.println("Scores retrieved: " + currentScores.getAll());  // Print the retrieved scores
        return currentScores;
    }
}
