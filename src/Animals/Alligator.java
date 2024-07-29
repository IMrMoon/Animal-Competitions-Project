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
 * The {@code Alligator} class represents an alligator, a type of water animal that also implements the {@code IReptile} interface.
 * This class extends the {@code WaterAnimal} class and includes additional attributes specific to alligators.
 *
 * <p>Each alligator has an area of living in addition to the attributes defined in the {@code WaterAnimal} class.</p>
 *
 * @see WaterAnimal
 * @see IReptile
 */
public class Alligator extends WaterAnimal implements IReptile, LandAnimal {
    private String areaOfLiving;
    private TerrestrialAnimals landAnimalDelegate;



    /**
     * Constructs a new {@code Alligator} with the specified details.
     *
     * @param animalName   the name of the alligator
     * @param animalGender the gender of the alligator
     * @param weight       the weight of the alligator
     * @param speed        the speed of the alligator
     * @param medalsArray  an array of medals the alligator has won
     * @param position     the position of the alligator
     * @param diveDept     the dive depth of the alligator
     * @param areaOfLiving the area where the alligator lives
     * @param pan          the competition panel
     * @param specificAnimal the specific category of the animal
     */
    public Alligator(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                     double diveDept,CompetitionPanel pan, String areaOfLiving, String specificAnimal) {
        super(animalName, animalGender, weight, speed, medalsArray, position, 0, "Roar", diveDept, pan, specificAnimal); // צליל המגורר על ידי נחישות
        this.areaOfLiving = areaOfLiving;
        loadImages("g");
        this.landAnimalDelegate = new TerrestrialAnimals(animalName, animalGender, weight, speed, medalsArray, position, 0, "Roar", 4, pan, specificAnimal) {

            /**
             * @param nm
             */
            @Override
            public void loadImages(String nm) {
                   setImg1("graphics2/alli_east.jpg");
                   setImg2("graphics2/alli_south.jpg");
                   setImg3("graphics2/alli_west.jpg");
                   setImg4("graphics2/alli_north.jpg");
            }
            /**
             * @return
             */
            @Override
            public String getAnimaleName() {
                return animalName;
            }

            /**
             * Returns the current location of the object.
             *
             * @return the current location as a {@code Point} object
             */
            @Override
            public Point getLocation() {
                return new Point(position.getX(), position.getY());
            }

            /**
             * Sets the location of the object to the specified point.
             *
             * @param p the new location as a {@code Point} object
             * @return {@code true} if the location was successfully set; {@code false} otherwise
             */
            @Override
            public boolean setLocation(Point p) {
                position.setX(p.getX());
                position.setY(p.getY());
                return true;
            }
        };
    }


    /**
     * Attempts to increase the speed of the alligator by the specified amount.
     * The speed increase will not be applied if it exceeds the maximum speed allowed.
     *
     * @param add_speed the amount to increase the speed by
     * @return {@code true} if the speed was successfully increased; {@code false} otherwise
     */
    @Override
    public boolean speedUp(int add_speed) {
        if (getSpeed() + add_speed > MAX_SPEED) {
            return false;
        } else {
            setSpeed(this.getSpeed() + add_speed);
        }
        return true;
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
        setPosition(p);
        return false;
    }

    /**
     * Returns the number of legs the alligator has.
     *
     * @return the number of legs
     */
    @Override
    public int NumberOfLegs() {
        return 4;
    }

    /**
     * Returns the name of the alligator.
     *
     * @return the name of the alligator
     */
    @Override
    public String getAnimaleName() {
        return getName();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two {@code Alligator} objects are considered equal if they have the same attributes, including the area of living.
     *
     * @param obj the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            Alligator w = (Alligator) obj;
            return this.areaOfLiving.equals(w.areaOfLiving);
        }
        return false;
    }

    /**
     * Returns a string representation of the {@code Alligator}.
     *
     * @return a string representation of the {@code Alligator}
     */
    public String toString() {
        return super.toString() + "areaOfLiving: " + areaOfLiving;
    }

    /**
     * Loads the images for the alligator based on the specified name.
     *
     * @param nm the name used to load the images
     */
    @Override
    public void loadImages(String nm) {
        setImg1("graphics2/alli_east.jpg");
    }
}
