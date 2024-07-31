package Animals;

import Graphics.CompetitionPanel;
import Mobility.Point;
import Olympics.Medal;


    public abstract class WaterAnimal extends Animal {
        private static final double MAX_DIVE = -800;
        private double diveDept;

        public WaterAnimal(String animalName, gender animalGender, double weight, double speed, Medal[] medalsArray, Point position,
                           double animalDistance, String sound, double diveDept, CompetitionPanel pan, String specificAnimal) {
            super(animalName, animalGender, weight, speed, medalsArray, position, animalDistance, sound, pan, "Water", specificAnimal);
            this.diveDept = diveDept;
        }

//        @Override
//        public void move() {
//            if (getEnergyLevel() <= 0) return;
//
//            getPosition().setX(getPosition().getX() + (int) getSpeed());
//            setEnergyLevel(getEnergyLevel() - getEnergyPerMeter());
//            animalDistance += getSpeed();
//        }

        public double Dive(double dive) {
            if (diveDept + dive < MAX_DIVE) {
                return MAX_DIVE;
            }
            return diveDept - dive;
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
