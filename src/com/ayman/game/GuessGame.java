package com.ayman.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessGame {
    private final List<Character> secretWord = new ArrayList<>();
    private int lifePoints;
    private final List<Character> guessedLetters = new ArrayList<>();
    private final Set<Character> enteredLetters = new HashSet<>();

    public GuessGame(String secretWord, int lifePoints) {
        for(char c : secretWord.toCharArray()){
            this.secretWord.add(c);
        }
        this.lifePoints = lifePoints;
        for(int i = 0; i < this.secretWord.size(); i++){
            guessedLetters.add('_');
        }
    }

    @Override
    public String toString() {
        return "GuessGame{" +
                "lifePoints=" + lifePoints +
                ", guessedLetters=" + guessedLetters +
                ", enteredLetters=" + enteredLetters +
                '}';
    }

    public void guessLetter(char letter) {
        enteredLetters.add(letter);
        if(secretWord.contains(letter) && !guessedLetters.contains(letter)){
            var i = 0;
            for(char c : secretWord){
                if(c == letter){
                    guessedLetters.set(i,letter);
                }
                i++;
            }
        }
        else{
            lifePoints--;
        }
    }

    public boolean isLost() {
        return lifePoints == 0;
    }

    public boolean isWon() {
        return !guessedLetters.contains('_');
    }
}
