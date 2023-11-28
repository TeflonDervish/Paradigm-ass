import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String inputFileName = "Lab 7/files/input.txt";
            String outputFileName = "Lab 7/files/output.txt";

            List<String> shortestVowelSurname = findShortestVowelSurname(inputFileName);
            System.out.println("Shortest vowel surname: " + shortestVowelSurname);
            writeToFile(outputFileName, shortestVowelSurname);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Метод для поиска самой короткой фамилии, начинающейся с гласной буквы
    private static List<String> findShortestVowelSurname(String fileName) throws IOException {
        List<String> vowelSurnames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int min = 9999999;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String surname = parts[0];
                    String name = parts[1];
                    if (isVowel(surname.charAt(0))) {
                        if (surname.length() < min){
                            min = surname.length();
                            vowelSurnames = new ArrayList<>();
                            vowelSurnames.add(surname);
                        }else if (surname.length() == min) {
                            vowelSurnames.add(surname);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Invalid data format in the file.");
                }
            }
        }
        if (vowelSurnames.isEmpty()) {
            throw new IllegalArgumentException("No surnames starting with a vowel found.");
        }

        return vowelSurnames;
    }


    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }


    private static void writeToFile(String fileName, List<String> content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < content.size(); i ++)
                writer.write(content.get(i) + "\n");
        }
    }
}