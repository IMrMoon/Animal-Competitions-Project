package Competitions;

import Animals.Animal;
import Graphics.CompetitionFrame;
import Graphics.CompetitionPanel;

import java.util.List;

/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The Tournament class is an abstract class that defines the structure for different types of tournaments
 * where animals compete. It manages the setup of the competition, determines the total distance for the race,
 * and provides a common interface for tournament-specific behavior.
 */
public abstract class Tournament {
    protected TournamentThread tournamentThread; // The thread managing the overall tournament
    private CompetitionPanel competitionPanel;   // The panel where the competition is displayed
    Scores scores;                                // The Scores object used to track the scores of the tournament


    /**
     * Constructs a Tournament with the specified animal groups, competition panel, and scores.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing.
     * @param competitionPanel the panel where the competition will be displayed.
     * @param scores the Scores object used to track the scores of the tournament.
     */
    public Tournament(List<List<Animal>> animalGroups, CompetitionPanel competitionPanel, Scores scores) {
        this.competitionPanel = competitionPanel;
        this.scores = scores;
        setup(animalGroups);
    }

    /**
     * Returns the thread managing the overall tournament.
     *
     * @return the TournamentThread object.
     */
    public TournamentThread getTournamentThread()
    {
        return tournamentThread;
    }

    /**
     * Abstract method to set up the tournament. This method must be implemented by subclasses to define
     * the specific setup behavior for different types of tournaments.
     *
     * @param animalGroups a list of lists of animals, where each list represents a group of animals competing.
     */
    public abstract void setup(List<List<Animal>> animalGroups);


    /**
     * Determines the total distance that animals need to travel in the competition based on the type of competition.
     * The distance is calculated differently depending on whether the competition is for Air, Water, or Terrestrial animals.
     *
     * @param competitionType the type of competition ("Air", "Water", "Terrestrial").
     * @return the total distance that animals need to travel in the competition.
     */
    public double determineTotalDistance(String competitionType) {
        if (competitionPanel != null) {
            if (competitionType.equals("Air")) {
                return competitionPanel.getBackgroundImg().getWidth();
            } else if (competitionType.equals("Water")) {
                return (competitionPanel.getBackgroundImg().getWidth() -  ((int)(competitionPanel.getBackgroundImg().getWidth() / 12) - 130));
            } else if (competitionType.equals("Terrestrial")) {
                return ((competitionPanel.getBackgroundImg().getHeight() * 2) + (competitionPanel.getBackgroundImg().getWidth() * 2));
            }
        }
        return 0;
    }
}
