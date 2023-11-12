import java.io.*;

public class SwapFiles {

    public static void main(String[] args) throws IOException {
        String f1 = "Lab 7/files/f1.txt";
        String f2 = "Lab 7/files/f2.txt";
        String tempFile = "Lab 7/files/temp.txt";

        swapFiles(f1, f2, tempFile);

        System.out.println("Files swapped successfully.");
    }

    // Метод для обмена содержимым двух файлов с использованием временного файла
    private static void swapFiles(String file1, String file2, String tempFile) throws IOException {
        // Чтение из файла f1 и запись во временный файл
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader1.readLine()) != null) {
                tempWriter.write(line);
                tempWriter.newLine();
            }
        }

        // Чтение из файла f2 и запись в файл f1
        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(file1))) {

            String line;
            while ((line = reader2.readLine()) != null) {
                writer1.write(line);
                writer1.newLine();
            }
        }

        // Чтение из временного файла и запись в файл f2
        try (BufferedReader tempReader = new BufferedReader(new FileReader(tempFile));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(file2))) {

            String line;
            while ((line = tempReader.readLine()) != null) {
                writer2.write(line);
                writer2.newLine();
            }
        }
    }
}