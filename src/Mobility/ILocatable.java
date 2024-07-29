package Mobility;

/**
 * The {@code ILocatable} interface represents an object that has a location.
 * It includes methods for getting and setting the location of the object.
 */
public interface ILocatable {
    /**
     * Returns the current location of the object.
     *
     * @return the current location as a {@code Point} object
     */
    public Point getLocation();

    /**
     * Sets the location of the object to the specified point.
     *
     * @param p the new location as a {@code Point} object
     * @return {@code true} if the location was successfully set; {@code false} otherwise
     */
    public boolean setLocation(Point p);
}
