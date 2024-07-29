package Animals;

import Mobility.Point;
import Olympics.Medal;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.InputMismatchException;
import Graphics.*;
/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Eagle} class represents an eagle, a type of air animal.
 * This class extends the {@code AirAnimal} class and includes additional attributes specific to eagles.
 *
 * <p>Each eagle has an altitude of flight in addition to the attributes defined in the {@code AirAnimal} class.</p>
 *
 * @see AirAnimal
 */
public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    public static final double MAX_ALTITUDE = 1000;

    /**
     * Constructs a new {@code Eagle} with the specified details.
     *
     * @param animalName the name of the eagle
     * @param animalGender the gender of the eagle
     * @param weight the weight of the eagle
     * @param speed the speed of the eagle
     * @param medalsArray an array of medals the eagle has won
     * @param position the position of the eagle
     * @param wingspan the wingspan of the eagle
     * @param altitudeOfFlight the altitude of flight of the eagle
     */
    public Eagle(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                 double wingspan,CompetitionPanel pan, double altitudeOfFlight, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Clack-wack-chack", wingspan, pan, specificAnimal);
        if (altitudeOfFlight > MAX_ALTITUDE) {
            this.altitudeOfFlight = MAX_ALTITUDE;
        } else {
            this.altitudeOfFlight = altitudeOfFlight;
        }
        loadImages("graphics2/eagle_east.jpg");
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Eagle} objects are considered equal if they have the same attributes, including the altitude of flight.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Eagle w = (Eagle) obj;
            return this.altitudeOfFlight == w.altitudeOfFlight;
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Eagle}.
     *
     * @return a string representation of the {@code Eagle}
     */
    public String toString() {
        return super.toString() + " altitude of flight: " + altitudeOfFlight;
    }

    /**
     * Returns the current location of the object.
     *
     * @return the current location as a {@code Point} object
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the object to the specified point.
     *
     * @param p the new location as a {@code Point} object
     * @return {@code true} if the location was successfully set; {@code false} otherwise
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }

    /**
     * @return
     */
    @Override
    public String getAnimaleName() {
        return getName();
    }

    /**
     * @param nm
     */
    @Override
    public void loadImages(String nm) {
        setImg1(nm);
    }
}
