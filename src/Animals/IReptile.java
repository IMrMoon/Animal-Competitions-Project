package Animals;

/**
 * The {@code IReptile} interface represents the characteristics and behaviors specific to reptiles.
 * It includes a method for increasing the speed of a reptile.
 */
public interface IReptile {
    /**
     * The maximum speed that a reptile can achieve.
     */
    public static final int MAX_SPEED = 5;

    /**
     * Attempts to increase the speed of the reptile by the specified amount.
     *
     * @param add_speed the amount to increase the speed by
     * @return {@code true} if the speed was successfully increased; {@code false} otherwise
     */
    public boolean speedUp(int add_speed);
}
