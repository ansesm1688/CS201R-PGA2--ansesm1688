import java.util.Scanner;

public class GameMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;
        
        System.out.println("Welcome to the Game Center!");
        System.out.println("==========================");
        
        while (!exitMenu) {
            // Display menu options
            System.out.println("\nPlease select a game:");
            System.out.println("1. Rock Paper Scissors");
            System.out.println("2. Lottery");
            System.out.println("3. Craps");
            System.out.println("4. Scraps");
            System.out.println("5. Rock Paper Scissors Spock");
            System.out.println("6. Hangman");
            System.out.println("7. Blackjack");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    System.out.println("\nStarting Rock Paper Scissors...");
                    System.out.println("===============================");
                    RockPaperScissors.main(args);
                    break;
                    
                case 2:
                    System.out.println("\nStarting Lottery...");
                    System.out.println("===================");
                    Lottery.main(args);
                    break;
                case 3:
                    System.out.println("\nStarting Craps...");
                    System.out.println("=================");
                    Craps.main(args);
                    break;
                    
                case 4:
                    System.out.println("\nStarting Scraps...");
                    System.out.println("==================");
                    Scraps.main(args);
                    break;
                    
                case 5:
                    System.out.println("\nStarting Rock Paper Scissors Spock...");
                    System.out.println("=====================================");
                    RockPaperScissorsSpock.main(args);
                    break;
                    
                case 6:
                    System.out.println("\nStarting Hangman...");
                    System.out.println("==================");
                    PlayHangman.playHangman(scanner);
                    break;
                    
                case 7:
                    System.out.println("\nStarting Blackjack...");
                    System.out.println("====================");
                    PlayBlackjack.playBlackjack(scanner);
                    break;
                    
                case 8:
                    System.out.println("Thank you for playing! Goodbye!");
                    exitMenu = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, 3, 4, 5, 6, 7, or 8.");
                    break;
            }
        }
        
        scanner.close();
    }
}