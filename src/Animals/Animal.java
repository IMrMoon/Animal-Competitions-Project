package Animals;

import Graphics.*;
import Mobility.ILocatable;
import Mobility.Mobile;
import Mobility.Point;
import Olympics.Medal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * The Animal class is an abstract class representing a generic animal.
 * It extends the Mobile class and includes attributes and methods common to all animals.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>animalName - The name of the animal.</li>
 *     <li>animalGender - The gender of the animal (Male, Female, Hermaphrodite).</li>
 *     <li>weight - The weight of the animal.</li>
 *     <li>speed - The speed of the animal.</li>
 *     <li>medalsArray - An array of medals won by the animal.</li>
 *     <li>position - The current position of the animal.</li>
 *     <li>sound - The sound the animal makes.</li>
 *     <li>animalDistance - The distance the animal has traveled.</li>
 *     <li>maxEnergy - The maximum energy level of the animal.</li>
 *     <li>energyPerMeter - The energy consumption per meter of travel.</li>
 *     <li>currentEnergy - The current energy level of the animal.</li>
 *     <li>size - The size of the animal.</li>
 *     <li>id - The identifier of the animal.</li>
 *     <li>orien - The orientation of the animal.</li>
 *     <li>pan - The competition panel.</li>
 *     <li>img1, img2, img3, img4 - Buffered images representing the animal in different orientations.</li>
 *     <li>scaleX, scaleY - Scaling factors for the animal images.</li>
 *     <li>animalType - The type of the animal.</li>
 *     <li>specificAnimal - The specific category of the animal.</li>
 *     <li>EnergyConsumption - The energy consumption of the animal.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>makeSound() - Prints the sound the animal makes.</li>
 *     <li>equals(Object obj) - Checks if two Animal objects are equal based on their attributes.</li>
 *     <li>toString() - Returns a string representation of the Animal object.</li>
 *     <li>getSpeed() - Returns the speed of the animal.</li>
 *     <li>setSpeed(double speed) - Sets the speed of the animal.</li>
 *     <li>setScale(double scaleX, double scaleY) - Sets the scale of the animal images.</li>
 *     <li>getScaleX() - Returns the X scale factor.</li>
 *     <li>getScaleY() - Returns the Y scale factor.</li>
 *     <li>getEnergyConsumption() - Returns the energy consumption.</li>
 *     <li>getAnimalType() - Returns the type of the animal.</li>
 *     <li>getSpecificAnimal() - Returns the specific category of the animal.</li>
 *     <li>setEnergyConsumption(int energyConsumption) - Sets the energy consumption.</li>
 *     <li>setImg1(String path), setImg2(String path), setImg3(String path), setImg4(String path) - Sets the images of the animal in different orientations.</li>
 *     <li>getImg1(), getImg2(), getImg3(), getImg4() - Returns the images of the animal in different orientations.</li>
 *     <li>getName() - Returns the name of the animal.</li>
 *     <li>getEnergyLevel() - Returns the current energy level.</li>
 *     <li>getMaxEnergyLevel() - Returns the maximum energy level.</li>
 *     <li>getEnergyPerMeter() - Returns the energy consumption per meter.</li>
 *     <li>getAnimalDistance() - Returns the distance the animal has traveled.</li>
 *     <li>getSize() - Returns the size of the animal.</li>
 *     <li>setEnergyLevel(int addEnergy) - Sets the current energy level of the animal.</li>
 *     <li>drawObject(Graphics g) - Draws the animal on the competition panel.</li>
 *     <li>eat(int energy) - Increases the energy level of the animal.</li>
 * </ul>
 *
 * @see Mobile
 */
public abstract class Animal extends Mobile implements IAnimal, IClonable, ILocatable, IMoveable, IDrawable {
    private String animalName;

    /**
     * Enum representing the gender of the animal.
     */
    public enum gender {Male, Female, Hermaphrodite}

    /**
     * Enum representing the orientation of the animal.
     */
    public enum Orientation {south, west, east, north}

    private gender animalGender;
    private double weight;
    private double speed;
    private Medal[] medalsArray = {};
    private String sound;
    protected double animalDistance;
    private int maxEnergy;
    private int energyPerMeter;
    private int currentEnergy = 0;
    protected int size;
    private int id;
    protected Orientation orien;
    protected CompetitionPanel pan;
    private BufferedImage img1, img2, img3, img4;
    private double scaleX = 1.0;
    private double scaleY = 1.0;
    private String animalType, specificAnimal;
    private int EnergyConsumption;

    /**
     * Constructs a new Animal object with the specified details.
     *
     * @param animalName     The name of the animal.
     * @param animalGender   The gender of the animal.
     * @param weight         The weight of the animal.
     * @param speed          The speed of the animal.
     * @param medalsArray    An array of medals won by the animal.
     * @param position       The current position of the animal.
     * @param animalDistance The distance the animal has traveled.
     * @param sound          The sound the animal makes.
     * @param pan            The competition panel.
     * @param animalType     The type of the animal.
     * @param specificAnimal The specific category of the animal.
     */

    public Animal(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                  double animalDistance, String sound, CompetitionPanel pan, String animalType, String specificAnimal) {
        super(position, 0);
        this.animalName = animalName;
        this.animalGender = animalGender;
        this.weight = weight;
        this.speed = speed;
        if (medalsArray != null) {
            this.medalsArray = new Medal[medalsArray.length];
            System.arraycopy(medalsArray, 0, this.medalsArray, 0, medalsArray.length);
        } else {
            this.medalsArray = new Medal[0];
        }
        this.sound = sound;
        this.setPosition(position);
        this.animalDistance = 0;
        this.size = 65;
        this.id = id;
        this.orien = Orientation.east;
        this.pan = pan;
        this.EnergyConsumption = 0;
        this.animalType = animalType;
        this.specificAnimal = specificAnimal;

    }

    /**
     * Constructs a new Animal object with default values.
     * Default values: animalName = "Dor", animalGender = gender.Male, weight = 1.0, speed = 0.0,
     * medalsArray = new Medal[0], sound = "none", position = new Point(0, 0), animalDistance = 0.
     */
    public Animal() {
        super(new Point(0, 0), 0);
        this.animalName = "Dor";
        this.animalGender = gender.Male;
        this.weight = 1.0;
        this.speed = 0.0;
        this.medalsArray = new Medal[0];
        this.sound = "none";
        this.setPosition(new Point(0, 0));
        this.animalDistance = 0;
        this.size = 65;
        this.orien = Orientation.east;
        this.pan = null;

    }

    /**
     * Sets the scale of the animal images.
     *
     * @param scaleX The X scale factor.
     * @param scaleY The Y scale factor.
     */
    public void setScale(double scaleX, double scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    /**
     * Returns the X scale factor.
     *
     * @return The X scale factor.
     */
    public double getScaleX() {
        return scaleX;
    }

    /**
     * Returns the Y scale factor.
     *
     * @return The Y scale factor.
     */
    public double getScaleY() {
        return scaleY;
    }

    /**
     * Returns the energy consumption.
     *
     * @return The energy consumption.
     */
    public int getEnergyConsumption() {
        return EnergyConsumption;
    }

    /**
     * Returns the type of the animal.
     *
     * @return The type of the animal.
     */
    public String getAnimalType() {
        return animalType;
    }

    /**
     * Returns the specific category of the animal.
     *
     * @return The specific category of the animal.
     */
    public String getSpecificAnimal() {
        return specificAnimal;
    }

    /**
     * Sets the energy consumption.
     *
     * @param energyConsumption The energy consumption to set.
     */
    public void setEnergyConsumption(int energyConsumption) {
        this.EnergyConsumption = energyConsumption;
    }

    /**
     * Sets the image for the east orientation.
     *
     * @param path The path to the image file.
     */
    protected void setImg1(String path){
        try {
            img1 = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Image not found");
        }
    }

    /**
     * Sets the image for the east orientation.
     *
     * @param path The path to the image file.
     */
    protected void setImg2(String path){
        try {
            img2 = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Image not found");
        }
    }

    /**
     * Sets the image for the east orientation.
     *
     * @param path The path to the image file.
     */
    protected void setImg3(String path){
        try {
            img3 = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Image not found");
        }
    }

    /**
     * Sets the image for the east orientation.
     *
     * @param path The path to the image file.
     */
    protected void setImg4(String path){
        try {
            img4 = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Image not found");
        }
    }

    /**
     * Returns the image for the east orientation.
     *
     * @return The image for the east orientation.
     */
    protected BufferedImage getImg1(){
        return img1;
    }

    /**
     * Returns the image for the east orientation.
     *
     * @return The image for the east orientation.
     */
    protected BufferedImage getImg2(){
        return img2;
    }

    /**
     * Returns the image for the east orientation.
     *
     * @return The image for the east orientation.
     */
    protected BufferedImage getImg3(){
        return img3;
    }

    /**
     * Returns the image for the east orientation.
     *
     * @return The image for the east orientation.
     */
    protected BufferedImage getImg4(){
        return img4;
    }

    /**
     * Prints the sound the animal makes.
     * Format: "Animal [animalName], said [sound]".
     */
    public final void makeSound() {
        System.out.println("Animal " + animalName + ", said " + sound);
    }


    /**
     * Returns the name of the animal.
     *
     * @return The name of the animal.
     */
    public String getName() {
        return animalName;
    }

    /**
     * Returns the speed of the animal.
     *
     * @return The speed of the animal.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the animal.
     *
     * @param speed The new speed of the animal.
     */
    protected void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Returns the current energy level of the animal.
     *
     * @return The current energy level.
     */
    public int getEnergyLevel() {
        return currentEnergy;
    }

    /**
     * Returns the maximum energy level of the animal.
     *
     * @return The maximum energy level.
     */
    public int getMaxEnergyLevel() {
        return maxEnergy;
    }

    /**
     * Returns the energy consumption per meter.
     *
     * @return The energy consumption per meter.
     */
    public int getEnergyPerMeter() {
        return energyPerMeter;
    }

    /**
     * Returns the distance the animal has traveled.
     *
     * @return The distance the animal has traveled.
     */
    public double getAnimalDistance() {
        return animalDistance;
    }

    /**
     * Returns the size of the animal.
     *
     * @return The size of the animal.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the current energy level of the animal.
     *
     * @param addEnergy The amount of energy to add.
     */
    public void setEnergyLevel(int addEnergy) {
        if (currentEnergy + addEnergy > maxEnergy) {
            currentEnergy = maxEnergy;
        } else {
            currentEnergy += addEnergy;
        }
    }

    /**
     * Draws the animal on the competition panel.
     *
     * @param g The graphics context.
     */
    public void drawObject (Graphics g)
    {
        if(orien==Orientation.east) // animal move to the east side
            g.drawImage(img1, getPosition().getX(), getPosition().getY()-size/10, size*2, size, pan);
        else if(orien==Orientation.south) // animal move to the south side
            g.drawImage(img2, getPosition().getX(), getPosition().getY()-size/10, size, size, pan);
        else if(orien==Orientation.west) // animal move to the west side
            g.drawImage(img3, getPosition().getX(), getPosition().getY()-size/10, size*2, size, pan);
        else if(orien==Orientation.north) // animal move to the north side
            g.drawImage(img4, getPosition().getX()-size/2, getPosition().getY()-size/10, size, size*2, pan);
    }


    /**
     * Checks if this Animal object is equal to another object.
     * Two Animal objects are considered equal if they have the same attributes.
     *
     * @param obj The object to compare this Animal object against.
     * @return true if the given object represents an Animal equivalent to this animal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Animal)) {
            return false;
        }
        Animal a = (Animal) obj;
        return animalName.equals(a.animalName) && animalGender == a.animalGender && weight == a.weight && speed == a.speed &&
                getPosition().equals(a.getPosition()) && sound.equals(a.sound) && Arrays.equals(medalsArray, a.medalsArray) &&
                animalDistance == a.animalDistance;
    }

    /**
     * Returns a string representation of this Animal object.
     * The string includes the details of the animal.
     *
     * @return A string representation of this Animal object.
     */
    @Override
    public String toString() {
        return "Animal: " + animalName + ", gender: " + animalGender + ", weight: " + weight + ", speed: " + speed +
                ", position: " + getPosition() + ", sound: " + sound + ", medals: " + Arrays.toString(medalsArray) +
                ", animalDistance: " + animalDistance;
    }


    /**
     * Increases the energy level of the animal.
     *
     * @param energy The amount of energy to add.
     * @return true if the energy level was successfully increased.
     */
    @Override
    public boolean eat(int energy) {
        if (currentEnergy + energy > maxEnergy) {
            currentEnergy = maxEnergy;
        }
        else
            currentEnergy += energy;
        return true;
    }
}
