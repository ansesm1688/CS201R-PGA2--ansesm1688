import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PlayHangman {

    public static void playHangman(Scanner input) {
        System.out.println("\nWELCOME TO HANGMAN!!\n");
        Random random = new Random();
        ArrayList<String> wordList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File("words.txt"))) {
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim().toLowerCase();
                if (!word.isEmpty()) {
                    wordList.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: words.txt file not found.");
            return;
        }

        if (wordList.isEmpty()) {
            System.out.println("The words.txt file is empty.");
            return;
        }            

        boolean keepPlaying = true;

        System.out.println("Welcome to Hangman!");

        while (keepPlaying) {
            String chosenWord = wordList.get(random.nextInt(wordList.size()));
            
            StringBuilder guessWord = new StringBuilder();
            for (int i = 0; i < chosenWord.length(); i++) {
                guessWord.append("_");
            }
            
            int wrongGuesses = 0;
            int maxGuesses = 6;
            ArrayList<Character> guessedLetters = new ArrayList<>();
            
            System.out.println("\nNew game started!");
            System.out.println("Word to guess: " + guessWord.toString());
            System.out.println("Wrong guesses remaining: " + (maxGuesses - wrongGuesses));
            
            while (wrongGuesses < maxGuesses && guessWord.toString().contains("_")) {
                System.out.print("\nEnter a letter: ");
                String userInput = input.nextLine().toLowerCase();
                
                if (userInput.length() != 1 || !Character.isLetter(userInput.charAt(0))) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }
                
                char guessedLetter = userInput.charAt(0);
                
                if (guessedLetters.contains(guessedLetter)) {
                    System.out.println("You already guessed that letter!");
                    continue;
                }
                
                guessedLetters.add(guessedLetter);
                
                boolean letterFound = false;
                for (int i = 0; i < chosenWord.length(); i++) {
                    if (chosenWord.charAt(i) == guessedLetter) {
                        guessWord.setCharAt(i, guessedLetter);
                        letterFound = true;
                    }
                }
                
                if (letterFound) {
                    System.out.println("Good guess!");
                } else {
                    wrongGuesses++;
                    System.out.println("Sorry, that letter is not in the word.");
                }
                
                // Display current state
                System.out.println("Word: " + guessWord.toString());
                System.out.println("Wrong guesses remaining: " + (maxGuesses - wrongGuesses));
                System.out.println("Guessed letters: " + guessedLetters);
            }
            
            if (!guessWord.toString().contains("_")) {
                System.out.println("\nCongratulations! You guessed the word: " + chosenWord);
            } else {
                System.out.println("\nSorry, you ran out of guesses!");
                System.out.println("The word was: " + chosenWord);
            }
            
            System.out.print("\nWould you like to play again? (y/n): ");
            String playAgain = input.nextLine().toLowerCase();
            if (!playAgain.startsWith("y")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing Hangman!");
    }
}