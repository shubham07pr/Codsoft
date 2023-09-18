import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalAttempts = 0;
        int roundsPlayed = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int randomNum = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            roundsPlayed++;

            System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange + ".");
            
            while (attempts < maxAttempts) {
                System.out.print("Guess the number (" + minRange + "-" + maxRange + "): ");
                int userGuess;

                try {
                    userGuess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next(); // Clear the invalid input
                    continue;
                }

                attempts++;

                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of the specified range.");
                } else if (userGuess < randomNum) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNum) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + randomNum + " in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    break;
                }
            }

            if (attempts >= maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + randomNum + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);
        sc.close();
        System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds and took " + totalAttempts + " attempts in total.");
    }
}
