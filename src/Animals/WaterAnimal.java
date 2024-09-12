package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class WaterAnimal extends Animal {
    private static final double MAX_DIVE = -800;
    private double diveDept;

    public WaterAnimal(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                       double animalDistance, String sound, double diveDept, CompetitionPanel pan, String specificAnimal, String groupName, int totalEnergy, int energyPerMeter) {
        super(animalName, animalGender, weight, speed, medalsArray, position, animalDistance, sound, pan, "Water", specificAnimal, groupName, totalEnergy, energyPerMeter);
        this.diveDept = diveDept;
    }

    public double Dive(double dive) {
        if (diveDept + dive < MAX_DIVE) {
            return MAX_DIVE;
        }
        return diveDept - dive;
    }

    @Override
    public void move() {

        Point pos = getPosition();
        int speed = (int) getSpeed();
        int panelWidth = pan.getBackgroundImg().getWidth();

        if (getCurrentEnergy() - METER >= 0) {
            if (orien == Orientation.east) {
                pos.setX(pos.getX() + speed); // תנועה אופקית ימינה
                if (pos.getX() >= (panelWidth - (panelWidth / 12 + getSize() * 2))) {
                    pos.setX(panelWidth - (int) (panelWidth / 12) - (getSize() * 2) - getSize() / 3);
                }
            }
        } else {
            return;
        }

        setCurrentEnergy(getCurrentEnergy() - (int)(((getSpeed() / METER) * getEnergyPerMeter())));
        this.addAnimalDistance(speed);
        setPosition(pos);
    }




        /**
     * Checks if this WaterAnimal object is equal to another object.
     * Two WaterAnimal objects are considered equal if they have the same attributes, including the dive depth.
     *
     * @param obj The object to compare this WaterAnimal object against.
     * @return true if the given object represents a WaterAnimal equivalent to this water animal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            WaterAnimal w = (WaterAnimal) obj;
            return this.diveDept == w.diveDept;
        }
        return false;
    }

    /**
     * Returns a string representation of this WaterAnimal object.
     * The string includes the details of the water animal, including the dive depth.
     *
     * @return A string representation of this WaterAnimal object.
     */
    @Override
    public String toString() {
        return super.toString() + ", diveDept: " + diveDept;
    }
}
