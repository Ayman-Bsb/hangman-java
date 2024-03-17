import com.ayman.game.GuessGame;

import java.util.Random;
import java.util.Scanner;

/**
 * Class of the entrypoint of Hangman Game.
 */
public class Main {
    /**
     * Entry point of Hangman Game. Contains the main algorithm of the game.
     */
    public static void main(String[] args) {
        final var random = new Random();
        final var words = "abuser crottes fleches continental babiole etoile bougie coup coeur malade".split(" ");
        final var lifePoints = 10;
        var wordToGuess = words[random.nextInt(words.length)];
        var game = new GuessGame(wordToGuess, 10);

        System.out.println("Début du jeu.");

        while (true){
            System.out.println(game);
            final var letter = getLetter("Entrez une seule lettre");

            game.guessLetter(letter);

            if(game.isLost()){
                System.out.println("Perdu !");
            }

            if(game.isWon()){
                System.out.println("Gagné !");
            }

            if(game.isLost() || game.isWon()){
                System.out.println(game);
                final var replayAnswer = getLetter("Rejouer ? ('o' pour confirmer)");
                if(replayAnswer == 'o'){
                    wordToGuess = words[random.nextInt(words.length)];
                    game = new GuessGame(wordToGuess, lifePoints);
                }
                else{
                    break;
                }
            }
        }
    }

    private static char getLetter(String request) {
        final var scanner = new Scanner(System.in);
        Character letter = null;
        do{
            System.out.println(request);
            var input = scanner.nextLine();
            if(input.length() == 1){
                letter = input.charAt(0);
            }
        } while (letter == null);
        return letter;
    }
}