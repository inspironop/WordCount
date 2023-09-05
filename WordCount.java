import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter 'T' for text input or 'F' to provide a file: ");
        String userChoice = scanner.nextLine();

        if (userChoice.equalsIgnoreCase("T")) {

            System.out.print("Enter the text: ");
            String inputText = scanner.nextLine();
            int wordCount = countWords(inputText);
            System.out.println("Total words: " + wordCount);
        } else if (userChoice.equalsIgnoreCase("F")) {

            System.out.print("Enter the file path: ");
            String filePath = scanner.nextLine();

            try {
                String fileContent = readFile(filePath);
                int wordCount = countWords(fileContent);
                System.out.println("Total words: " + wordCount);
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice. Please enter 'T' or 'F'.");
        }

        scanner.close();
    }


    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }


    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}

