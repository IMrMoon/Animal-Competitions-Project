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
 * The TerrestrialAnimals class is an abstract class representing a generic terrestrial animal.
 * The {@code TerrestrialAnimals} class is an abstract class representing a generic terrestrial animal.
 * It extends the {@code Animal} class and includes attributes and methods specific to terrestrial animals.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>noLegs - The number of legs the terrestrial animal has.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code equals(Object obj)} - Checks if two {@code TerrestrialAnimals} objects are equal based on their attributes, including the number of legs.</li>
 *     <li>{@code toString()} - Returns a string representation of the {@code TerrestrialAnimals} object.</li>
 *     <li>{@code move()} - Moves the terrestrial animal by updating its position based on its orientation and speed.</li>
 * </ul>
 *
 * @see Animal
 */
public abstract class TerrestrialAnimals extends Animal {
    private int noLegs;

    /**
     * Constructs a new {@code TerrestrialAnimals} object with the specified details.
     *
     * @param animalName     The name of the animal.
     * @param animalGender   The gender of the animal.
     * @param weight         The weight of the animal.
     * @param speed          The speed of the animal.
     * @param medalsArray    An array of medals won by the animal.
     * @param position       The current position of the animal.
     * @param animalDistance The distance the animal has traveled.
     * @param sound          The sound the animal makes.
     * @param noLegs         The number of legs the terrestrial animal has.
     * @param pan            The competition panel.
     * @param specificAnimal The specific category of the animal.
     */
    public TerrestrialAnimals(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                              double animalDistance, String sound, int noLegs, CompetitionPanel pan, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, animalDistance, sound, pan, "Terrestrial", specificAnimal);
        this.noLegs = noLegs;
        loadImages("y");
    }

    /**
     * Constructs a new TerrestrialAnimals object with default values.
     * Default values: animalName = "DefaultName", animalGender = gender.Male, weight = 3.0, speed = 3.0,
     * medalsArray = new Medal[0], position = new Point(0, 20), animalDistance = 0.0, sound = "DefaultSound", noLegs = 4.
     */
//    public TerrestrialAnimals() {
//        super("DefaultName", gender.Male, 3, 3, new Medal[0], new Point(0, 20), 0.0, "DefaultSound");
//        this.noLegs = 4;
//    }

    /**
     * Checks if this {@code TerrestrialAnimals} object is equal to another object.
     * Two {@code TerrestrialAnimals} objects are considered equal if they have the same attributes, including the number of legs.
     *
     * @param obj The object to compare this {@code TerrestrialAnimals} object against.
     * @return true if the given object represents a {@code TerrestrialAnimals} equivalent to this terrestrial animal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            TerrestrialAnimals w = (TerrestrialAnimals) obj;
            return noLegs == w.noLegs;
        }
        return false;
    }

    /**
     * Returns a string representation of this TerrestrialAnimals object.
     * The string includes the details of the terrestrial animal, including the number of legs.
     *
     * @return A string representation of this TerrestrialAnimals object.
     */
    @Override
    public String toString() {
        return super.toString() + ", NoLegs: " + noLegs;
    }


    @Override
    public void move() {
        Point pos = getPosition();
        int speed = (int) getSpeed();

        int panelWidth = pan.getWidth();
        int panelHeight = pan.getHeight();


        if (orien == Orientation.east) {
            pos.setX(pos.getX() + speed); // Increase horizontal movement
            if (pos.getX() >= panelWidth - 350) { // גבול ימני של הפאנל
                pos.setX(panelWidth - 350);
                orien = Orientation.south;
            }
        } else if (orien == Orientation.south) {
            pos.setY(pos.getY() + speed); // Increase vertical movement
            if (pos.getY() >= panelHeight +65) { // גבול תחתון של הפאנל
                pos.setY(panelHeight +65);
                orien = Orientation.west;
            }
        } else if (orien == Orientation.west) {
            pos.setX((pos.getX() - speed)); // Decrease horizontal movement
            if (pos.getX() <= speed) { // גבול שמאלי של הפאנל
                pos.setX(0);
                orien = Orientation.north;
            }
        } else if (orien == Orientation.north) {
            pos.setY(pos.getY() - speed); // Decrease vertical movement
            if (pos.getY() <= 65) { // גבול עליון של הפאנל
                pos.setY(0);
                orien = Orientation.east;
            }
        }

        setPosition(pos);
    }
}