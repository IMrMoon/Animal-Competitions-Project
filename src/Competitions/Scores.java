package Competitions;

import java.util.*;

/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The Scores class represents a thread-safe map that stores names associated with their respective timestamps.
 * This class allows adding names to the map along with the current timestamp and retrieving the entire map of scores.
 */
public class Scores {
    private Map<String, Date> scores; // Thread-safe map to store the names and their corresponding timestamps.


    /**
     * Constructs a new Scores object with a synchronized map.
     */
    public Scores(){
        scores = Collections.synchronizedMap(new HashMap<>());
    }

    /**
     * Securely adds a name to the map along with the current timestamp.
     *
     * @param name the name to be added to the map
     */
    public void add(String name){ //Securely adds the string into the queue with updated time.
        scores.put(name, new Date());
    }

    /**
     * Returns the entire map of scores.
     *
     * @return a map containing names and their respective timestamps
     */
    public Map<String, Date> getAll() { //return scores.
        return scores;
    }
}
