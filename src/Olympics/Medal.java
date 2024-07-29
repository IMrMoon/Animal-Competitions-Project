package Olympics;

import java.util.Objects;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The Medal class represents a medal won in a tournament.
 * It includes attributes to store the tournament name, the year it was won, and the type of medal.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>tournament - The name of the tournament where the medal was won.</li>
 *     <li>year - The year the medal was won.</li>
 *     <li>type - The type of the medal (BRONZE, SILVER, GOLD).</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>equals(Object m) - Checks if two Medal objects are equal based on their tournament name, year, and type.</li>
 *     <li>toString() - Returns a string representation of the Medal object.</li>
 * </ul>
 */
public class Medal {
    /**
     * Enum representing the type of medal.
     */
    public enum Medaltype { BRONZE, SILVER, GOLD }

    private String tournament;
    private int year;
    private Medaltype type;

    /**
     * Constructs a new Medal object with the specified details.
     *
     * @param tournament The name of the tournament where the medal was won.
     * @param type The type of the medal.
     * @param year The year the medal was won.
     */
    public Medal(String tournament, Medaltype type, int year) {
        this.tournament = tournament;
        this.year = year;
        this.type = type;
    }

    /**
     * Constructs a new Medal object with default values.
     * Default values: tournament = "WorldCup", year = 2024, type = Medaltype.GOLD.
     */
    public Medal() {
        this.tournament = "WorldCup";
        this.year = 2024;
        this.type = Medaltype.GOLD;
    }

    /**
     * Checks if this Medal object is equal to another object.
     * Two Medal objects are considered equal if they have the same tournament name, year, and type.
     *
     * @param m The object to compare this Medal object against.
     * @return true if the given object represents a Medal equivalent to this medal, false otherwise.
     */
    @Override
    public boolean equals(Object m) {
        if (this == m) {
            return true;
        }
        if (!(m instanceof Medal)) {
            return false;
        }
        Medal newMedal = (Medal) m;
        return this.tournament.equals(newMedal.tournament) &&
                this.year == newMedal.year &&
                this.type == newMedal.type;
    }

    /**
     * Returns a string representation of this Medal object.
     * The string includes the tournament name, year, and type of the medal.
     *
     * @return A string representation of this Medal object.
     */
    @Override
    public String toString() {
        return tournament + " " + year + " " + type;
    }
}
