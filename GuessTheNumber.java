import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int rounds;
        int totalScore = 0;

        System.out.println("===== WELCOME TO GUESS THE NUMBER GAME =====");
        System.out.println("Tip: Enter 0 anytime to EXIT the game.");
        System.out.print("Enter how many rounds you want to play: ");
        rounds = sc.nextInt();

        for (int r = 1; r <= rounds; r++) {

            System.out.println("\n=== ROUND " + r + " ===");

            int randomNumber = rand.nextInt(100) + 1; // range 1–100
            int attempts = 0;
            int maxAttempts = 7;  // limit attempts
            int scorePerRound = 0;
            boolean guessed = false;

            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (or 0 to exit): ");
                int guess = sc.nextInt();

                // ---------- Exit feature ----------
                if (guess == 0) {
                    System.out.println("\nGame Exited by User!");
                    System.out.println("Your total score so far: " + totalScore);
                    System.out.println("Thanks for playing!");
                    return;   // End the whole game
                }

                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number!");
                    guessed = true;

                    scorePerRound = (maxAttempts - attempts + 1) * 10;
                    break;

                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("You ran out of attempts!");
                System.out.println("The correct number was: " + randomNumber);
            } else {
                System.out.println("You guessed it in " + attempts + " attempts.");
                System.out.println("Score for this round: " + scorePerRound);
            }

            totalScore += scorePerRound;
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Your total score after all rounds: " + totalScore);
        System.out.println("Thank you for playing!");
    }
}
