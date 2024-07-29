package Animals;

import Mobility.Point;
import Olympics.Medal;
import Graphics.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Cat} class represents a terrestrial animal of breed cat.
 * It extends the {@code TerrestrialAnimals} class and includes additional attributes
 * specific to cats.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>Castrated - Indicates whether the cat is castrated or not.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code equals(Object obj)} - Checks if two {@code Cat} objects are equal based on their castration status.</li>
 *     <li>{@code toString()} - Returns a string representation of the {@code Cat} object including its castration status.</li>
 *     <li>{@code getLocation()} - Returns the current location of the cat as a {@code Point} object.</li>
 *     <li>{@code setLocation(Point p)} - Sets the location of the cat to the specified point.</li>
 *     <li>{@code getAnimaleName()} - Returns the name of the cat.</li>
 *     <li>{@code loadImages(String nm)} - Loads the images for the cat based on the specified name.</li>
 * </ul>
 *
 * @see TerrestrialAnimals
 */
public class Cat extends TerrestrialAnimals {
    private boolean Castrated;

    /**
     * Constructs a new {@code Cat} object with the specified details.
     *
     * @param animalName   The name of the cat.
     * @param animalGender The gender of the cat.
     * @param weight       The weight of the cat.
     * @param speed        The speed of the cat.
     * @param medalsArray  An array of medals won by the cat.
     * @param position     The current position of the cat.
     * @param noLegs       The number of legs the cat has.
     * @param Castrated    Indicates whether the cat is castrated or not.
     * @param pan          The competition panel.
     * @param specificAnimal The specific category of the animal.
     */
    public Cat(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
               int noLegs,CompetitionPanel pan, boolean Castrated, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Meow", noLegs,pan, specificAnimal);
        this.Castrated = Castrated;
        loadImages("y");
    }


    /**
     * Returns the current location of the cat.
     *
     * @return The current location as a {@code Point} object.
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the cat to the specified point.
     *
     * @param p The new location as a {@code Point} object.
     * @return {@code true} if the location was successfully set; {@code false} otherwise.
     */
    @Override
    public boolean setLocation(Point p) {
        return false;
    }


    /**
     * Returns the name of the cat.
     *
     * @return The name of the cat.
     */
    @Override
    public String getAnimaleName() {
        return getName();
    }


    /**
     * Checks if this {@code Cat} object is equal to another object.
     * Two {@code Cat} objects are considered equal if they have the same attributes,
     * including the castration status.
     *
     * @param obj The object to compare this {@code Cat} object against.
     * @return {@code true} if the given object represents a {@code Cat} equivalent to this cat, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Cat w = (Cat) obj;
            return this.Castrated == w.Castrated;
        }
        return false;
    }

    /**
     * Returns a string representation of this {@code Cat} object.
     * The string includes the details of the terrestrial animal along with the castration status of the cat.
     *
     * @return A string representation of this {@code Cat} object.
     */
    @Override
    public String toString() {
        return super.toString() + " Castrated: " + Castrated;
    }

    /**
     * Loads the images for the cat based on the specified name.
     *
     * @param nm The name used to load the images.
     */
    @Override
    public void loadImages(String nm) {
        setImg1("graphics2/cat_east.jpg");
        setImg2("graphics2/cat_south.jpg");
        setImg3("graphics2/cat_west.jpg");
        setImg4("graphics2/cat_north.jpg");
    }
}