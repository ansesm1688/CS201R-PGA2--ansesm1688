import java.util.Scanner;
import java.util.Random;


public class Lottery {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int lottoNum;
        int userNum;
        boolean gameOver = false;

        //lottoNum = rand.


        System.out.println("Welcome to the lottery!");
        while (!gameOver){
            lottoNum = rand.nextInt(1, 100);
            String lottoString = String.valueOf(lottoNum);
            System.out.println("Enter a two digit number: ");
            userNum = scanner.nextInt();
            String userString = String.valueOf(userNum);
            
            boolean sameDigits = (userString.charAt(0) == lottoString.charAt(0) && userString.charAt(1) == lottoString.charAt(1)) ||
                     (userString.charAt(0) == lottoString.charAt(1) && userString.charAt(1) == lottoString.charAt(0));
            if(userNum == lottoNum){
                System.out.println("The winning number is: " + lottoNum + ". You selected: " + userNum + ". Congratulations!! You've won and earned $10,000!!");
                gameOver = true;
            }
            else if(sameDigits){
                System.out.println("The winning number is: " + lottoNum + ". You selected: " + userNum + ". So close but not exact! You still won $3,000!");
                gameOver = true;
            }
            else if((userString.charAt(0) == lottoString.charAt(1)) || (userString.charAt(1) == lottoString.charAt(0))){
                System.out.println("The winning number is: " + lottoNum + ". You selected: " + userNum + ". You guessed one number correctly. You've won $1,000!"); 
                gameOver = true;
            }
            else {
                System.out.println("The winning number is: " + lottoNum + ". You selected: " + userNum + ". No match. Better luck next time!");
                gameOver = true;
            }

            }
            // End of while loop

        
        scanner.close();
        }

        
    }
    

