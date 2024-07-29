package Graphics;
/**
 * The {@code IAnimal} interface represents an animal that has the ability to move and eat.
 * It extends the {@code IMoveable} interface to include movement capabilities.
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code eat(int energy)} - Simulates the animal eating and increasing its energy.</li>
 * </ul>
 *
 * @see IMoveable
 */
public interface IAnimal extends IMoveable{
    /**
     * Simulates the animal eating and increasing its energy.
     *
     * @param energy The amount of energy to be consumed.
     * @return {@code true} if the energy was successfully consumed and the animal's energy increased; {@code false} otherwise.
     */
    public boolean eat(int energy);
}
