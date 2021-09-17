package model;

import java.util.ArrayList;
import java.util.Random;

public class WordGuess {
    private ArrayList<String> wordBank = new ArrayList<String>();
    private String currentWord;
    private int health = 5;

    public WordGuess() {
        wordBank.add("communication");
        wordBank.add("science");
        wordBank.add("programming");
        wordBank.add("language");
        wordBank.add("difficulty");
        wordBank.add("artificial");
        wordBank.add("intelligence");
        wordBank.add("attempts");
        wordBank.add("screenshot");
        wordBank.add("baseball");
        wordBank.add("windows");
        wordBank.add("learning");
        wordBank.add("electronics");
        wordBank.add("beautiful");
        wordBank.add("internet");
        wordBank.add("database");
        wordBank.add("organization");
        wordBank.add("application");
        wordBank.add("network");
        wordBank.add("friendly");
        wordBank.add("validation");
        wordBank.add("attempts");
        wordBank.add("statistics");
        wordBank.add("physics");
        wordBank.add("chemistry");
        wordBank.add("engineering");
        wordBank.add("school");
        wordBank.add("industry");
        wordBank.add("revolution");
        wordBank.add("progress");
        wordBank.add("characters");
        wordBank.add("heavily");
        wordBank.add("graphics");
    }

    public void setWord() {
        Random r = new Random();
        currentWord = wordBank.get(r.nextInt(wordBank.size()));
        health = 5;
    }

    public String getWord() {
        return currentWord;
    }

    public int getHealth() {
        return health;
    }

    public boolean reduceHealth() {
        health--;
        return (health == 0) ? true : false;
    }
}
