package Animals;

import Mobility.Point;
import Olympics.Medal;

import java.awt.*;
import java.awt.image.BufferedImage;
import Graphics.*;
/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Pigeon} class represents a pigeon, a type of air animal.
 * This class extends the {@code AirAnimal} class and includes additional attributes specific to pigeons.
 *
 * <p>Each pigeon has a family type in addition to the attributes defined in the {@code AirAnimal} class.</p>
 *
 * @see AirAnimal
 */
public class Pigeon extends AirAnimal {
    private String family;

    /**
     * Constructs a new {@code Pigeon} with the specified details.
     *
     * @param animalName the name of the pigeon
     * @param animalGender the gender of the pigeon
     * @param weight the weight of the pigeon
     * @param speed the speed of the pigeon
     * @param medalsArray an array of medals the pigeon has won
     * @param position the position of the pigeon
     * @param wingspan the wingspan of the pigeon
     * @param pan the competition panel
     * @param family the family of the pigeon
     * @param specificAnimal the specific category of the animal
     */
    public Pigeon(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                  double wingspan,CompetitionPanel pan ,String family, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Arr-rar-rar-rar-raah", wingspan, pan, specificAnimal);
        this.family = family;
        loadImages("graphics2/pigeon_east.jpg");
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Pigeon} objects are considered equal if they have the same attributes, including the family.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Pigeon w = (Pigeon) obj;
            return this.family.equals(w.family);
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Pigeon}.
     *
     * @return a string representation of the {@code Pigeon}
     */
    public String toString() {
        return super.toString() + " Family: " + family;
    }

    /**
     * Returns the current location of the pigeon.
     *
     * @return the current location as a {@code Point} object
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the pigeon to the specified point.
     *
     * @param p the new location as a {@code Point} object
     * @return {@code true} if the location was successfully set; {@code false} otherwise
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }

    /**
     * Simulates the pigeon eating and increasing its energy.
     * Currently, this method returns {@code false} as it is not implemented.
     *
     * @param energy the amount of energy to be consumed
     * @return {@code false} always, as the method is not implemented
     */
    @Override
    public boolean eat(int energy) {
        return false;
    }

    /**
     * Returns the name of the pigeon.
     *
     * @return the name of the pigeon
     */
    @Override
    public String getAnimaleName() {
        return getName();
    }

    /**
     * Loads the images for the pigeon based on the specified name.
     *
     * @param nm the name used to load the images
     */
    @Override
    public void loadImages(String nm) {
        setImg1(nm);
    }
}
