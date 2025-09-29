import java.util.Scanner;
import java.util.Random;



public class Craps {
    public static void main(String[] args){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        double netWorth;
        int die1;
        int die2;
        int roll;
        boolean gameOver = false;

        while(!gameOver){
            System.out.println("Welcome to Craps!");
            System.out.println("-----------------");
            System.out.println("Please enter (1) or (2)");
            int choice = scanner.nextInt();
            netWorth = 50.00;
            if(choice == 1){
                while(netWorth > 0.00){
                    System.out.printf("\nYour current net worth is: $ %.2f. Let's begin!", netWorth);
                    die1 = random.nextInt(1,7);
                    die2 = random.nextInt(1, 7);
                    System.out.println("\nPlease make your bet (enter 0 to exit):");
                    double bet = scanner.nextDouble();
                    if(bet == 0){
                        System.out.println("\nThank you for playing!\nExiting game...");
                        gameOver = true;
                        break;
                    }
                    else if(bet > netWorth){
                        System.out.println("ERROR: Bet exceeded net worth");
                    }
                    else{
                        roll = die1 + die2;
                        System.out.println("You rolled: " + die1 + "+" + die2 + "=" + roll);
                        if (roll == 7 || roll == 11){
                            System.out.printf("Congratulations! You win!");
                            netWorth += bet;
                        }
                        else if (roll == 2 || roll == 3 || roll == 12){
                            System.out.println("I'm sorry but you lose!");
                            netWorth -= bet;
                        }
                        else{
                            int point = roll;
                            System.out.println("Point is " + point);
                            die1 = random.nextInt(1, 7);
                            die2 = random.nextInt(1, 7);
                            roll = die1 + die2;
                            if (roll == point){
                                System.out.println("You rolled " + roll + ".\nCOngratulations! You win!");
                                netWorth += bet;
                            }
                            else{
                                System.out.println("You rolled " + roll + ".\nUh oh! You lost!");
                                netWorth -= bet;
                            }

                        }
                        

                    }


                }
            


            }

        }
        scanner.close();
    }
    
}
