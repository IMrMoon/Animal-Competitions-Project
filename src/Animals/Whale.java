package Animals;

import Mobility.Point;
import Olympics.Medal;
import Graphics.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.InputMismatchException;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Whale} class represents a whale, a type of water animal.
 * This class extends the {@code WaterAnimal} class and includes additional attributes specific to whales.
 *
 * <p>Each whale has a food type in addition to the attributes defined in the {@code WaterAnimal} class.</p>
 *
 * @see WaterAnimal
 */
public class Whale extends WaterAnimal {
    private String foodType;



    /**
     * Constructs a new {@code Whale} with the specified details.
     *
     * @param animalName   the name of the whale
     * @param animalGender the gender of the whale
     * @param weight       the weight of the whale
     * @param speed        the speed of the whale
     * @param medalsArray  an array of medals the whale has won
     * @param position     the position of the whale
     * @param diveDept     the dive depth of the whale
     * @param pan          the competition panel
     * @param foodType     the type of food the whale eats
     * @param specificAnimal the specific category of the animal
     */
    public Whale(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                 double diveDept, CompetitionPanel pan, String foodType, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Splash", diveDept, pan, specificAnimal);
        this.foodType = foodType;
        loadImages("graphics2/whale_east.jpg");
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Whale} objects are considered equal if they have the same attributes, including the food type.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Whale w = (Whale) obj;
            return this.foodType.equals(w.foodType);
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Whale}.
     *
     * @return a string representation of the {@code Whale}
     */
    public String toString() {
        return super.toString() + " Food type: " + foodType;
    }

    /**
     * Returns the current location of the whale.
     *
     * @return the current location as a {@code Point} object
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the whale to the specified point.
     *
     * @param p the new location as a {@code Point} object
     * @return {@code true} if the location was successfully set; {@code false} otherwise
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }

    /**
     * Returns the name of the whale.
     *
     * @return the name of the whale
     */
    @Override
    public String getAnimaleName() {
        return getName();
    }

    /**
     * Loads the images for the whale based on the specified name.
     *
     * @param nm the name used to load the images
     */
    @Override
    public void loadImages(String nm) {
        setImg1(nm);
    }
}
