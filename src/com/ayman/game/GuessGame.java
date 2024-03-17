package com.ayman.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class responsible for representing the Hangman Game. Provides methods to :
 * - validate if the game is won or lost
 * - validate if a given letter is considered discovered or not in the secret word
 */
public class GuessGame {
    /**
     * Stores the secret word to be discovered
     */
    private final List<Character> secretWord = new ArrayList<>();
    /**
     * Stores the remaining number of life points.
     */
    private int lifePoints;
    /**
     * Stores letters discovered by the player. '_' stored for not discovered letters.
     */
    private final List<Character> guessedLetters = new ArrayList<>();
    /**
     * Stores letters that the player has used to try to discover the secret word.
     */
    private final Set<Character> enteredLetters = new HashSet<>();

    /**
     * Build a Hangman Game object.
     * @param secretWord the secret word the player has to discover.
     * @param lifePoints the number of retries allowed to discover the secret word.
     */
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

    /**
     * Algorithm which verifies if a char given by the player is discovered in the secret word.
     * @param letter The letter to validate in `secretWord` and `guessedLetters`.
     */
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

    /**
     * Check if the game is lost.
     * @return boolean true if the game is lost, false otherwise.
     */
    public boolean isLost() {
        return lifePoints == 0;
    }

    /**
     * Check if the game is won.
     * @return boolean true if the game is won, false otherwise.
     */
    public boolean isWon() {
        return !guessedLetters.contains('_');
    }
}
