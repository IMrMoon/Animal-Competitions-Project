package Animals;

import Mobility.Point;
import Graphics.*;
import Olympics.Medal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Dog} class represents a terrestrial animal of breed dog.
 * It extends the {@code TerrestrialAnimals} class and includes additional attributes
 * specific to dogs.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>breed - The breed of the dog.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code equals(Object obj)} - Checks if two {@code Dog} objects are equal based on their breed.</li>
 *     <li>{@code toString()} - Returns a string representation of the {@code Dog} object including its breed.</li>
 *     <li>{@code getLocation()} - Returns the current location of the dog as a {@code Point} object.</li>
 *     <li>{@code setLocation(Point p)} - Sets the location of the dog to the specified point.</li>
 *     <li>{@code getAnimaleName()} - Returns the name of the dog.</li>
 *     <li>{@code loadImages(String nm)} - Loads the images for the dog based on the specified name.</li>
 * </ul>
 *
 * @see TerrestrialAnimals
 */
public class Dog extends TerrestrialAnimals {
    private String breed;

    /**
     * Constructs a new {@code Dog} object with the specified details.
     *
     * @param animalName   The name of the dog.
     * @param animalGender The gender of the dog.
     * @param weight       The weight of the dog.
     * @param speed        The speed of the dog.
     * @param medalsArray  An array of medals won by the dog.
     * @param position     The current position of the dog.
     * @param noLegs       The number of legs the dog has.
     * @param pan          The competition panel.
     * @param breed        The breed of the dog.
     * @param specificAnimal The specific category of the animal.
     */
    public Dog(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
               int noLegs, CompetitionPanel pan, String breed, String specificAnimal, String groupName, int totalEnergy, int energyPerMeter) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Woof Woof", noLegs, pan, specificAnimal, groupName, totalEnergy, energyPerMeter);
        this.breed = breed;
        loadImages("h");
    }

    /**
     * Returns the current location of the dog.
     *
     * @return The current location as a {@code Point} object.
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the dog to the specified point.
     *
     * @param p The new location as a {@code Point} object.
     * @return {@code true} if the location was successfully set; {@code false} otherwise.
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }



    /**
     * Checks if this {@code Dog} object is equal to another object.
     * Two {@code Dog} objects are considered equal if they have the same attributes,
     * including the breed.
     *
     * @param obj The object to compare this {@code Dog} object against.
     * @return {@code true} if the given object represents a {@code Dog} equivalent to this dog, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Dog w = (Dog) obj;
            return this.breed.equals(w.breed);
        }
        return false;
    }

    /**
     * Returns a string representation of this {@code Dog} object.
     * The string includes the details of the terrestrial animal along with the breed of the dog.
     *
     * @return A string representation of this {@code Dog} object.
     */
    @Override
    public String toString() {
        return super.toString() + " breed: " + breed;
    }

    /**
     * Loads the images for the dog based on the specified name.
     *
     * @param nm The name used to load the images.
     */
    @Override
    public void loadImages(String nm) {
        this.setImg1("graphics2/dog_east.jpg");
        this.setImg2("graphics2/dog_south.jpg");
        this.setImg3("graphics2/dog_west.jpg");
        this.setImg4("graphics2/dog_north.jpg");
    }
}