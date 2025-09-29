import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsSpock {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        boolean gameOver = false;
        
        String rock = "ROCK";
        String paper = "PAPER";
        String scissors = "SCISSORS";
        String spock = "SPOCK";

        String computerChoice;
        while (!gameOver){
            int num = rand.nextInt(4);
            //System.out.println(num); //testing whether or not a random integer was being generated
            System.out.println("Please enter your choice: (Rock, Paper, Scissors, Spock, or Exit)");
            String userChoice = scanner.nextLine();
            userChoice = userChoice.toUpperCase();
            System.out.println("You selected: " + userChoice);
            if(num == 0){
            computerChoice = "ROCK";
            /*comparing strings should use the method .equals rather than '==' */
            if(userChoice.equals(computerChoice)){
                System.out.println("The computer also selected " + rock + ". It's a draw! Please make another selection: ");
            }
            else if(userChoice.equals("PAPER")){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Congratulations! You win! GAME OVER");
                gameOver = true;
            }
            else if(userChoice.equals(spock)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Spock pulverizes rock! You win!");
                gameOver = true;
            }
            else{
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". I'm sorry, but you LOSE!! GAME OVER");
                gameOver = true;
            }
        }
            else if(num == 1){
            computerChoice = "SCISSORS";
            if(userChoice.equals(computerChoice)){
                System.out.println("The computer also selected " + scissors + ". It's a draw! Please make another selection.");
            }
            else if(userChoice.equals(rock)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Congratulations! You win! GAME OVER");
                gameOver = true;
            }
            else if(userChoice.equals(spock)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Spock uses scissors! You win!");
                gameOver = true;
            }
            else{
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". I'm sorry, but you LOSE!! GAME OVER");
                gameOver = true;
            }

        }
        else if (num == 2){
            computerChoice = "PAPER";
            if(userChoice.equals(computerChoice)){
                System.out.println("The computer also selected " + paper + ". It's a draw! Please make another selection");
            }
            else if(userChoice.equals(scissors)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Congratulations! You win! GAME OVER");
                gameOver = true;
            }
            else if(userChoice.equals(spock)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Paper exposes Spock as a fraud! You lose!");
                gameOver = true;
            }
            else{
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". I'm sorry, but you LOSE!! GAME OVER");
                gameOver = true;
            }
        }
        else{
            computerChoice = "SPOCK";
            if(userChoice.equals(computerChoice)){
                System.out.println("The computer also selected: " + spock + ". It's a draw! Please make another selection");
            }
            else if(userChoice.equals(scissors)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Spock uses scissors! You lose!");
                gameOver = true;
            }
            else if(userChoice.equals(rock)){
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Spock pulverizes rock! You lose!");
                gameOver = true;
            }
            else{
                System.out.println("The computer selected: " + computerChoice + ". You selected: " + userChoice + ". Paper exposes Spock as a fraud! You win!");
            }
        }
        }
        
        

        scanner.close();
    }
    }


