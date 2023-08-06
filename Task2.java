import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter text or provide a file name: ");
        String userInput = input.nextLine();

        String[] words;

        if (userInput.endsWith(".txt")) {
            // Read text from a file
            words = readTextFromFile(userInput);
        } else {
            // Split the user's input
            words = userInput.split("[\\p{Punct}\\s]+");
        }

        int totalWords = words.length;

        System.out.println("Total number of words: " + totalWords);

        // Additional features (optional)
        // Uncomment the lines below to enable these features

        // Count unique words
        // Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        // int uniqueWordCount = uniqueWords.size();
        // System.out.println("Number of unique words: " + uniqueWordCount);

        // Word frequency
        // Map<String, Integer> wordFrequency = new HashMap<>();
        // for (String word : words) {
        //     wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        // }
        // System.out.println("Word frequency: " + wordFrequency);

        input.close();
    }

    private static String[] readTextFromFile(String fileName) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        return text.toString().split("[\\p{Punct}\\s]+");
    }
}
