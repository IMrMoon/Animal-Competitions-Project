package Mobility;
import java.util.Scanner;
import Olympics.Medal;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Mobile} class represents an abstract mobile entity that can move and has a location.
 * It implements the {@code ILocatable} interface and includes methods to calculate distance, move, and manage total distance traveled.
 *
 * @see ILocatable
 */
public abstract class Mobile implements ILocatable {
    private Point position;
    private double totalDistance;

    /**
     * Constructs a new {@code Mobile} with the specified location and initial total distance.
     *
     * @param location the initial location of the mobile entity
     * @param totalDistance the initial total distance traveled
     */
    public Mobile(Point location, double totalDistance) {
        this.position = location;
        this.totalDistance = 0;
    }

    /**
     * Constructs a new {@code Mobile} with default values.
     * The default values are:
     * <ul>
     * <li>location: new Point(1, 1)</li>
     * <li>totalDistance: 0</li>
     * </ul>
     */
    public Mobile() {
        this.position = new Point(1, 1);
        this.totalDistance = 0;
    }

    /**
     * Adds the specified additional distance to the total distance traveled.
     * If the result is negative, the total distance remains unchanged and an error message is printed.
     *
     * @param additionalDistance the additional distance to add
     */
    public void addTotalDistance(double additionalDistance) {
        if (totalDistance + additionalDistance > 0) {
            totalDistance = totalDistance + additionalDistance;
        } else {
            System.out.println("Can't add the distance, total distance will be negative");
        }
    }

    /**
     * Calculates the distance between the current location and another point.
     *
     * @param otherPoint the point to calculate the distance to
     * @return the calculated distance
     */
    public double calcDistance(Point otherPoint) {
        return Math.sqrt(Math.pow((position.getX() - otherPoint.getX()), 2) + Math.pow((position.getY() - otherPoint.getY()), 2));
    }

    /**
     * Gets the current location of the mobile entity.
     *
     * @return the current location
     */
    public Point getPosition() {
        return new Point(position.getX(),position.getY());
    }

    /**
     * Sets the location of the mobile entity to the specified point.
     * If the point has negative coordinates, they are set to 1.
     *
     * @param p the new location
     * @return {@code true} if the location was set successfully
     */
    public boolean setPosition(Point p) {
        Point p1 = new Point(p.getX(),p.getY());
        position = p1;
        return true;
    }

    /**
     * Moves the mobile entity to the specified point.
     * The distance traveled is calculated and added to the total distance.
     *
     * @param otherPoint the point to move to
     * @return the distance traveled
     */
    public boolean move(Point otherPoint) {
        if (position.equals(otherPoint)) {
            return false;
        }
        double distanceTraveled = calcDistance(otherPoint);
        addTotalDistance(distanceTraveled);
        position.setX(otherPoint.getX());
        position.setY(otherPoint.getY());
        return true;
    }
}
