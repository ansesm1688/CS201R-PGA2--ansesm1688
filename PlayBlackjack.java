import java.util.*;
public class PlayBlackjack {
    public static void playBlackjack(Scanner scanner) {
        System.out.println("\nWELCOME TO BLACKJACK!!\n");
        List<Integer> deck = new ArrayList<>();

        // Initialize deck
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        boolean keepPlaying = true;
        while (keepPlaying) {
            Collections.shuffle(deck);
            int deckIndex = 0;
            List<Integer> playerHand = new ArrayList<>();
            List<Integer> dealerHand = new ArrayList<>();

            playerHand.add(deck.get(deckIndex++));
            dealerHand.add(deck.get(deckIndex++));
            playerHand.add(deck.get(deckIndex++));
            dealerHand.add(deck.get(deckIndex++));

            boolean playerBust = false;
            boolean playerStands = false;
            
            while (!playerBust && !playerStands) {
                System.out.println("\nYour cards: " + getHandString(playerHand));
                System.out.println("Your total: " + getHandValue(playerHand));
                
                int playerTotal = getHandValue(playerHand);
                if (playerTotal > 21) {
                    playerBust = true;
                    System.out.println("BUST! You went over 21!");
                    break;
                }
                
                System.out.print("Would you like another card? (y/n): ");
                String choice = scanner.nextLine().toLowerCase();
                
                if (choice.startsWith("y")) {
                    playerHand.add(deck.get(deckIndex++));
                } else {
                    playerStands = true;
                }
            }

            boolean dealerBust = false;
            
            if (!playerBust) {
                System.out.println("\nDealer's cards: " + getHandString(dealerHand));
                System.out.println("Dealer's total: " + getHandValue(dealerHand));
                
                while (getHandValue(dealerHand) <= 17) {
                    System.out.println("Dealer must hit...");
                    dealerHand.add(deck.get(deckIndex++));
                    System.out.println("Dealer's cards: " + getHandString(dealerHand));
                    System.out.println("Dealer's total: " + getHandValue(dealerHand));
                }
                
                if (getHandValue(dealerHand) > 21) {
                    dealerBust = true;
                    System.out.println("Dealer BUST! Dealer went over 21!");
                }
            }

            int playerTotal = getHandValue(playerHand);
            int dealerTotal = getHandValue(dealerHand);
            
            System.out.println("\n--- FINAL RESULTS ---");
            System.out.println("Your final total: " + playerTotal);
            if (!playerBust) {
                System.out.println("Dealer's final total: " + dealerTotal);
            }
            
            if (playerBust) {
                System.out.println("You LOSE! (Player busted)");
            } else if (dealerBust) {
                System.out.println("You WIN! (Dealer busted)");
            } else if (playerTotal > dealerTotal) {
                System.out.println("You WIN! (Higher total)");
            } else if (dealerTotal > playerTotal) {
                System.out.println("You LOSE! (Dealer has higher total)");
            } else {
                System.out.println("PUSH! (Same total)");
            }
            
            System.out.print("\nWould you like to play another round? (y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.startsWith("y")) {
                keepPlaying = false;
            }
        }

        System.out.println("Thanks for playing!");
    }

    // Get Blackjack value of a card (1–13 -> 1–11, all face cards are worth 10)
    public static int getCardValue(int cardNumber) {
        int faceValue = (cardNumber - 1) % 13 + 1;
        if (faceValue >= 10) return 10;
        return faceValue;
    }

    // Get the string of a hand for display
    public static String getHandString(List<Integer> hand) {
        List<String> cards = new ArrayList<>();
        for (int card : hand) {
            cards.add(cardToString(card));
        }
        return String.join(", ", cards);
    }

    public static String cardToString(int cardNumber) {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        int faceIndex = (cardNumber - 1) % 13;
        int suitIndex = (cardNumber - 1) / 13;

        return faces[faceIndex] + " of " + suits[suitIndex];
    }

    // Compute Blackjack hand value with Ace handling (1 or 11)
    public static int getHandValue(List<Integer> hand) {
        int total = 0;
        int aces = 0;
        
        for (int card : hand) {
            int value = getCardValue(card);
            if (value == 1) {
                aces++;
                total += 11;
            } else {
                total += value;
            }
        }
        
        while (total > 21 && aces > 0) {
            total -= 10;
            aces--;
        }
        
        return total;
    }
}