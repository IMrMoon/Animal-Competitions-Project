package Graphics;

import Mobility.Point;

/**
 * The {@code IMoveable} interface represents an object that can move.
 * It defines methods for retrieving the name and speed of the moving object, as well as for moving the object.
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code getAnimaleName()} - Returns the name of the moving object.</li>
 *     <li>{@code getSpeed()} - Returns the speed of the moving object.</li>
 *     <li>{@code move()} - Moves the object.</li>
 * </ul>
 */
public interface IMoveable {

    /**
     * Returns the name of the moving object.
     *
     * @return The name of the moving object.
     */
    public String getAnimaleName();

    /**
     * Returns the speed of the moving object.
     *
     * @return The speed of the moving object.
     */
    public double getSpeed();

    /**
     * Moves the object.
     */
    public void move();
}
