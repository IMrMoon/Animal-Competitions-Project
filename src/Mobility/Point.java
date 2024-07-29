package Mobility;

import Graphics.IClonable;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Point} class represents a point in a 2D space with x and y coordinates.
 * It includes methods for getting and setting the coordinates, and for comparing points.
 */
public class Point implements IClonable {
    private int x;
    private int y;

    /**
     * Constructs a new {@code Point} with the specified coordinates.
     * If either coordinate is negative, it is set to 1.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        if (x < 0) {
            this.x = 1;
        } else {
            this.x = x;
        }
        if (y < 0) {
            this.y = 1;
        } else {
            this.y = y;
        }
    }

    /**
     * Constructs a new {@code Point} with default coordinates (1, 1).
     */
    public Point() {
        this.x = 1;
        this.y = 1;
    }

    /**
     * Returns the x-coordinate of the point.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the point.
     * The coordinate is not set if the provided value is negative.
     *
     * @param x the new x-coordinate
     * @return {@code true} if the x-coordinate was successfully set; {@code false} otherwise
     */
    public boolean setX(int x) {
        if (x < 0) {
            return false;
        }
        this.x = x;
        return true;
    }

    /**
     * Returns the y-coordinate of the point.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the point.
     * The coordinate is not set if the provided value is negative.
     *
     * @param y the new y-coordinate
     * @return {@code true} if the y-coordinate was successfully set; {@code false} otherwise
     */
    public boolean setY(int y) {
        if (y < 0) {
            return false;
        }
        this.y = y;
        return true;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Point} objects are considered equal if they have the same coordinates.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point newPoint = (Point) obj;
        return x == newPoint.x && y == newPoint.y;
    }

    /**
     * Returns a string representation of the {@code Point}.
     *
     * @return a string representation of the {@code Point} in the format (x, y)
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
