package Competitions;

import java.util.Map;

public class Referee implements Runnable{
    private String name;
    private Scores scores;

    @Override
    public void run() {
        scores.add(name);
    }

    public Referee(String name, Scores scores) {
        this.name = name;
        this.scores = scores;
    }
}
