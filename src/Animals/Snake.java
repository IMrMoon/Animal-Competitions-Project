package Animals;

import Graphics.CompetitionPanel;
import Graphics.IClonable;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Mobility.Point;
import Olympics.Medal;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.InputMismatchException;

/**
 * Names: Segev Chen 322433400
 *        Yinon Alfasi 208810374
 * The {@code Snake} class represents a specific type of terrestrial animal.
 * It extends the {@code TerrestrialAnimals} class and implements the {@code IReptile} interface.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>poison - Indicates whether the snake is poisonous.</li>
 *     <li>length - The length of the snake.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code equals(Object obj)} - Checks if two {@code Snake} objects are equal based on their attributes.</li>
 *     <li>{@code toString()} - Returns a string representation of the {@code Snake} object.</li>
 *     <li>{@code speedUp(int add_speed)} - Increases the speed of the snake.</li>
 * </ul>
 *
 * @see TerrestrialAnimals
 * @see IReptile
 */
public class Snake extends TerrestrialAnimals implements IReptile {

    /**
     * Enum representing whether the snake is poisonous.
     */
    public enum poisonous { low, medium, high } ///fix in sys class

    private poisonous poison;
    private double length;

    /**
     * Constructs a new {@code Snake} object with the specified details.
     *
     * @param animalName   The name of the snake.
     * @param animalGender The gender of the snake.
     * @param weight       The weight of the snake.
     * @param speed        The speed of the snake.
     * @param medalsArray  An array of medals won by the snake.
     * @param position     The current position of the snake.
     * @param poison       Indicates whether the snake is poisonous.
     * @param length       The length of the snake.
     * @param pan          The competition panel.
     * @param specificAnimal The specific category of the animal.
     */
    public Snake(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position, CompetitionPanel pan,
                 poisonous poison, double length, String specificAnimal, String groupName, int totalEnergy, int energyPerMeter) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "ssssssss", 0 , pan, specificAnimal, groupName, totalEnergy, energyPerMeter);
        this.poison = poison;
        this.length = length;
        loadImages("y");
    }


    /**
     * Checks if this {@code Snake} object is equal to another object.
     * Two {@code Snake} objects are considered equal if they have the same attributes, including whether they are poisonous and their length.
     *
     * @param obj The object to compare this {@code Snake} object against.
     * @return {@code true} if the given object represents a {@code Snake} equivalent to this snake, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Snake w = (Snake) obj;
            return this.poison == w.poison && this.length == w.length;
        }
        return false;
    }

    /**
     * Returns a string representation of this {@code Snake} object.
     * The string includes the details of the snake, including whether it is poisonous and its length.
     *
     * @return A string representation of this {@code Snake} object.
     */
    @Override
    public String toString() {
        return super.toString() + "poisonous: " + poison + ", length: " + length;
    }

    /**
     * Increases the speed of the snake by the specified amount.
     * If the new speed exceeds the maximum speed (MAX_SPEED), the speed is not increased.
     *
     * @param add_speed The amount to increase the speed.
     * @return {@code true} if the speed was successfully increased, {@code false} otherwise.
     */
    @Override
    public boolean speedUp(int add_speed) {
        if (getSpeed() + add_speed > MAX_SPEED) {
            return false;
        } else {
            setSpeed(this.getSpeed() + add_speed);
            return true;
        }
    }
    /**
     * Returns the current location of the snake.
     *
     * @return The current location as a {@code Point} object.
     */
    @Override
    public Point getLocation() {
        return getPosition();
    }

    /**
     * Sets the location of the snake to the specified point.
     *
     * @param p The new location as a {@code Point} object.
     * @return {@code true} if the location was successfully set; {@code false} otherwise.
     */
    @Override
    public boolean setLocation(Point p) {
        return setPosition(p);
    }



    /**
     * Loads the images for the snake based on the specified name.
     *
     * @param nm The name used to load the images.
     */
    @Override
    public void loadImages(String nm) {
        setImg1("graphics2/snake_east.jpg");
        setImg2("graphics2/snake_south.jpg");
        setImg3("graphics2/snake_west.jpg");
        setImg4("graphics2/sanke_north.jpg");
    }
}
