package Graphics;

import Animals.Animal;
import Mobility.Point;

import java.util.List;


/**
 * The SetAnimalLocationRelay class is responsible for setting the initial locations and orientations
 * of a group of animals in a relay competition based on their type (Terrestrial, Water, Air) and the size of the group.
 * This class provides methods to handle different scenarios depending on the type of animals and their quantity.
 */

public class SetAnimalLocationRelay {

    /**
     * Constructs a SetAnimalLocationRelay object.
     * Initializes the animal group and sets their positions based on their type and the size of the group.
     *
     * @param animalGroup a list of animals participating in the relay.
     * @param pan the CompetitionPanel where the animals will be displayed.
     * @throws NullPointerException if the animalGroup is null.
     */

    public SetAnimalLocationRelay(List<Animal> animalGroup, CompetitionPanel pan) {
        if (animalGroup == null) {
            throw new NullPointerException("animalGroup is null");
        }

        groupTypeSwitch(animalGroup, pan);
    }

    /**
     * Determines the type of the animal group (Terrestrial, Water, Air) and calls the appropriate method
     * to set their positions accordingly.
     *
     * @param animalGroup a list of animals participating in the relay.
     * @param pan the CompetitionPanel where the animals will be displayed.
     */
    public void groupTypeSwitch(List<Animal> animalGroup, CompetitionPanel pan){
        switch (animalGroup.get(0).getAnimalType()){
            case "Terrestrial":
            {
                terrestrialSwitch(animalGroup, pan);
                break;
            }
            case "Water":
            {
                waterSwitch(animalGroup, pan);
                break;
            }
            case "Air":
            {
                airSwitch(animalGroup, pan);
                break;
            }
            default:
            {
                break;
            }

        }
    }


    /**
     * Sets the positions and orientations of terrestrial animals based on the size of the animal group.
     *
     * @param animalGroup a list of terrestrial animals participating in the relay.
     * @param pan the CompetitionPanel where the animals will be displayed.
     * @throws NullPointerException if the animalGroup is empty.
     */
    public void terrestrialSwitch(List<Animal> animalGroup, CompetitionPanel pan){
        switch (animalGroup.size()){
            case 0:
            {
                throw new NullPointerException("animalGroup is null");
            }
            case 1:
            {
                animalGroup.get(0).setPosition(new Point(0,0));
                break;
            }
            case 2:
            {
                animalGroup.get(0).setPosition(new Point(0,0));
                animalGroup.get(1).setPosition(new Point(pan.getBackgroundImg().getWidth() - (animalGroup.get(1).getSize() * 2), pan.getBackgroundImg().getHeight() - (animalGroup.get(1).getSize())));
                animalGroup.get(1).setOrientation(Animal.Orientation.west);
                break;
            }
            case 3:
            {
                animalGroup.get(0).setPosition(new Point(0,0));
                animalGroup.get(1).setPosition(new Point(pan.getBackgroundImg().getWidth()-animalGroup.get(1).getSize(),  (int)(pan.getBackgroundImg().getHeight() / 3)));
                animalGroup.get(1).setOrientation(Animal.Orientation.south);
                animalGroup.get(2).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 3),(pan.getBackgroundImg().getHeight() - (animalGroup.get(2).getSize()))));
                animalGroup.get(2).setOrientation(Animal.Orientation.west);
                break;
            }
            case 4:
            {
                animalGroup.get(0).setPosition(new Point(0,0));

                animalGroup.get(1).setPosition(new Point(pan.getBackgroundImg().getWidth() - animalGroup.get(1).getSize(),0));
                animalGroup.get(1).setOrientation(Animal.Orientation.south);

                animalGroup.get(2).setPosition(new Point(pan.getBackgroundImg().getWidth() - (animalGroup.get(2).getSize() * 2),pan.getBackgroundImg().getHeight() - (animalGroup.get(2).getSize())));
                animalGroup.get(2).setOrientation(Animal.Orientation.west);

                animalGroup.get(3).setPosition(new Point(0,pan.getBackgroundImg().getHeight() - (animalGroup.get(3).getSize() * 2)));
                animalGroup.get(3).setOrientation(Animal.Orientation.north);

                break;
            }
        }
    }

    /**
     * Sets the positions of water animals based on the size of the animal group.
     *
     * @param animalGroup a list of water animals participating in the relay.
     * @param pan the CompetitionPanel where the animals will be displayed.
     * @throws NullPointerException if the animalGroup is empty.
     */
    public void waterSwitch(List<Animal> animalGroup, CompetitionPanel pan){
        switch (animalGroup.size()){
            case 0:
            {
                throw new NullPointerException("animalGroup is null");
            }
            case 1:
            {
                break;
            }
            case 2:
            {
                animalGroup.get(1).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 2) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                break;
            }
            case 3:
            {
                animalGroup.get(1).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 3) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                animalGroup.get(2).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 3) * 2) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                break;
            }
            case 4:
            {
                animalGroup.get(1).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 4)) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                animalGroup.get(2).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 4) * 2) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                animalGroup.get(3).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 4) * 3) + (animalGroup.get(0).getLocation().getX()) - (animalGroup.get(1).getSize() * 2),animalGroup.get(1).getLocation().getY()));
                break;
            }
        }
    }

    /**
     * Sets the positions of air animals based on the size of the animal group.
     *
     * @param animalGroup a list of air animals participating in the relay.
     * @param pan the CompetitionPanel where the animals will be displayed.
     * @throws NullPointerException if the animalGroup is empty.
     */
    public void airSwitch(List<Animal> animalGroup, CompetitionPanel pan){
        switch (animalGroup.size()){
            case 0:
            {
                throw new NullPointerException("animalGroup is null");
            }
            case 1:
            {
                break;
            }
            case 2:
            {
                animalGroup.get(1).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 2) - (animalGroup.get(1).getSize() * 2) , animalGroup.get(1).getLocation().getY()));
                break;
            }
            case 3:
            {
                animalGroup.get(1).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 3) ,animalGroup.get(1).getLocation().getY()));
                animalGroup.get(2).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 3) * 2)  ,animalGroup.get(1).getLocation().getY()));
                break;
            }
            case 4:
            {
                animalGroup.get(1).setPosition(new Point((int)(pan.getBackgroundImg().getWidth() / 4) ,animalGroup.get(1).getLocation().getY()));
                animalGroup.get(2).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 4) * 2)  ,animalGroup.get(1).getLocation().getY()));
                animalGroup.get(3).setPosition(new Point((int)((pan.getBackgroundImg().getWidth() / 4) * 3) ,animalGroup.get(1).getLocation().getY()));
                break;
            }
        }
    }
}
