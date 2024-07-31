package Competitions;

import java.util.*;

public class Scores {
    private Map<String, Date> scores; //Queue which we will add the string and the time.

    public void add(String name){ //Securely adds the string into the queue with updated time.
        scores.put(name, new Date());
    }

    public Map<String, Date> getAll() { //return scores.
        return scores;
    }

    public Scores(){
    scores = Collections.synchronizedMap(new HashMap<>());
    }
}
