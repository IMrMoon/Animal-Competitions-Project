package Animals;

import Graphics.CompetitionPanel;
import Graphics.IClonable;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Mobility.Point;
import Olympics.Medal;

import java.awt.image.BufferedImage;
import java.util.InputMismatchException;
import java.util.Objects;

/**
 * The {@code AirAnimal} class represents an abstract animal that can fly.
 * It extends the {@code Animal} class and includes additional attributes specific to air animals.
 *
 * <p>Each air animal has a wingspan in addition to the attributes defined in the {@code Animal} class.</p>
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>wingspan - The wingspan of the air animal.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code move()} - Moves the air animal by updating its position and energy level.</li>
 *     <li>{@code equals(Object obj)} - Checks if two {@code AirAnimal} objects are equal based on their attributes, including the wingspan.</li>
 *     <li>{@code toString()} - Returns a string representation of the {@code AirAnimal}.</li>
 * </ul>
 *
 * @see Animal
 */
public abstract class AirAnimal extends Animal {
    private double wingspan;

    /**
     * Constructs a new {@code AirAnimal} object with the specified details.
     *
     * @param animalName     The name of the animal.
     * @param animalGender   The gender of the animal.
     * @param weight         The weight of the animal.
     * @param speed          The speed of the animal.
     * @param medalsArray    An array of medals won by the animal.
     * @param position       The current position of the animal.
     * @param animalDistance The distance the animal has traveled.
     * @param sound          The sound the animal makes.
     * @param wingspan       The wingspan of the air animal.
     * @param pan            The competition panel.
     * @param specificAnimal The specific category of the animal.
     */
    public AirAnimal(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                     double animalDistance, String sound, double wingspan, CompetitionPanel pan, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, animalDistance, sound, pan, "Air", specificAnimal);
        this.wingspan = wingspan;
    }

    /**
     * Moves the air animal by updating its position and energy level.
     * If the energy level is zero or less, the animal does not move.
     */
//    @Override
//    public void move() {
//        if (getEnergyLevel() <= 0) return;
//
//        getPosition().setX(getPosition().getX() + (int) getSpeed());
//        setEnergyLevel(getEnergyLevel() - getEnergyPerMeter());
//        animalDistance += getSpeed();
//    }

    /**
     * Constructs a new {@code AirAnimal} with default values.
     * The default values are:
     * <ul>
     * <li>animalName: "DefaultName"</li>
     * <li>animalGender: gender.Male</li>
     * <li>weight: 3</li>
     * <li>speed: 2</li>
     * <li>medalsArray: empty array</li>
     * <li>position: new Point(0, 100)</li>
     * <li>animalDistance: 0.0</li>
     * <li>sound: "DefaultSound"</li>
     * <li>wingspan: 10</li>
     * </ul>
     */
//    public AirAnimal() {
//        super("DefaultName", gender.Male, 3, 2, new Medal[0], new Point(0, 100), 0.0, "DefaultSound");
//        this.wingspan = 10;
//    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code AirAnimal} objects are considered equal if they have the same attributes, including the wingspan.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            AirAnimal a = (AirAnimal) obj;
            return this.wingspan == a.wingspan;
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code AirAnimal}.
     *
     * @return A string representation of the {@code AirAnimal}.
     */
    public String toString() {
        return super.toString() + ", wingspan: " + wingspan;
    }

}
