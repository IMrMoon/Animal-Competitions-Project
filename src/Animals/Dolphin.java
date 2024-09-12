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
 * The {@code Dolphin} class represents a dolphin, a type of water animal.
 * This class extends the {@code WaterAnimal} class and includes additional attributes specific to dolphins.
 *
 * <p>Each dolphin has a water type (sea or sweet) in addition to the attributes defined in the {@code WaterAnimal} class.</p>
 *
 * @see WaterAnimal
 */
public class Dolphin extends WaterAnimal {
    private WaterType waterType;



    /**
     * The {@code WaterType} enum represents the types of water a dolphin can live in.
     */
    public enum WaterType {Sea, Sweet}

    /**
     * Constructs a new {@code Dolphin} with the specified details.
     *
     * @param animalName the name of the dolphin
     * @param animalGender the gender of the dolphin
     * @param weight the weight of the dolphin
     * @param speed the speed of the dolphin
     * @param medalsArray an array of medals the dolphin has won
     * @param position the position of the dolphin
     * @param diveDept the dive depth of the dolphin
     * @param pan the competition panel
     * @param waterType the type of water the dolphin lives in
     * @param specificAnimal the specific category of the animal
     */
    public Dolphin(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                   double diveDept,CompetitionPanel pan ,WaterType waterType, String specificAnimal, String groupName, int totalEnergy, int energyPerMeter) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Click-click", diveDept, pan, specificAnimal, groupName, totalEnergy, energyPerMeter);
        this.waterType = waterType;
        loadImages("graphics2/dolp_east.jpg");
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Dolphin} objects are considered equal if they have the same attributes, including the water type.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Dolphin w = (Dolphin) obj;
            return this.waterType.equals(w.waterType);
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Dolphin}.
     *
     * @return a string representation of the {@code Dolphin}
     */
    public String toString() {
        return super.toString() + " Water type: " + waterType;
    }

    /**
     * Returns the current location of the dolphin.
     *
     * @return the current location as a {@code Point} object
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the dolphin to the specified point.
     *
     * @param p the new location as a {@code Point} object
     * @return {@code true} if the location was successfully set; {@code false} otherwise
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }


    /**
     * Loads the images for the dolphin based on the specified name.
     *
     * @param nm the name used to load the images
     */
    @Override
    public void loadImages(String nm) {
        setImg1(nm);
    }
}
