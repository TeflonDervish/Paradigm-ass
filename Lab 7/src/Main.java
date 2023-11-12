import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String inputFileName = "Lab 7/files/input.txt";
            String outputFileName = "Lab 7/files/output.txt";

            String shortestVowelSurname = findShortestVowelSurname(inputFileName);
            System.out.println("Shortest vowel surname: " + shortestVowelSurname);

            writeToFile(outputFileName, shortestVowelSurname);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Метод для поиска самой короткой фамилии, начинающейся с гласной буквы
    private static String findShortestVowelSurname(String fileName) throws IOException {
        List<String> vowelSurnames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String surname = parts[0];
                    String name = parts[1];
                    if (isVowel(surname.charAt(0))) {
                        vowelSurnames.add(surname);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid data format in the file.");
                }
            }
        }

        if (vowelSurnames.isEmpty()) {
            throw new IllegalArgumentException("No surnames starting with a vowel found.");
        }

        Collections.sort(vowelSurnames);
        return vowelSurnames.get(0);
    }

    // Метод для проверки, является ли символ гласной буквой
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    // Метод для записи строки в файл
    private static void writeToFile(String fileName, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }
    }
}