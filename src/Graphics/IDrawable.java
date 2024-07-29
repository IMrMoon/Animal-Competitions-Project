package Graphics;

import java.awt.Graphics;

/**
 * The {@code IDrawable} interface represents an object that can be drawn and can load images.
 * This interface defines methods for loading images and drawing objects on a graphical context.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>{@code PICTURE_PATH} - The path to the directory where images are stored.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code loadImages(String nm)} - Loads the images required for the drawable object.</li>
 *     <li>{@code drawObject(Graphics g)} - Draws the object on the provided {@code Graphics} context.</li>
 * </ul>
 */
public interface IDrawable {

    /**
     * The path to the directory where images are stored.
     */
    public final static String PICTURE_PATH = "…";

    /**
     * Loads the images required for the drawable object.
     *
     * @param nm The name used to load the images.
     */
    public void loadImages(String nm);

    /**
     * Draws the object on the provided {@code Graphics} context.
     *
     * @param g The {@code Graphics} context on which the object is to be drawn.
     */
    public void drawObject(Graphics g);
}
