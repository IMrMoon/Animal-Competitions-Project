package Graphics;
import java.lang.Cloneable;
/**
 * The {@code IClonable} interface represents an object that can be cloned.
 * It extends the {@code Cloneable} interface from the Java standard library.
 *
 * <p>This interface does not declare any methods. It is used as a marker interface to indicate that
 * implementing classes can be safely cloned using the {@code Object.clone()} method.</p>
 *
 * @see java.lang.Cloneable
 */
public interface IClonable extends Cloneable {
}
