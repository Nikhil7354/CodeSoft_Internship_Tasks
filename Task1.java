import java.util.Scanner;
import java.util.Random;

    public class Task1 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            Random random = new Random();

            int lowerBound = 1;
            int upperBound = 100;
            int maxAttempts = 5;
            int score = 0;

            boolean playAgain = true;

            while (playAgain) {
                int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
                System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ".");

                int attempts = 0;
                boolean guessedCorrectly = false;

                while (!guessedCorrectly && attempts < maxAttempts) {
                    System.out.print("Enter your guess: ");
                    int userGuess = input.nextInt();
                    attempts++;

                    if (userGuess == generatedNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        score++;
                        guessedCorrectly = true;
                    } else if (userGuess < generatedNumber) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }

                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've reached the maximum number of attempts.");
                    System.out.println("The number was: " + generatedNumber);
                }

                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainChoice = input.next();
                playAgain = playAgainChoice.equalsIgnoreCase("yes");
            }

            System.out.println("Game over!");
            System.out.println("Your score: " + score);

            input.close();
        }
    }
