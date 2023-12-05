import java.io.File;
import java.util.Scanner;

public class FileSearchThread extends Thread {
    private static int totalThreads = 0;
    private static int activeThreads = 0;
    private static int totalFiles = 0;

    private String directory;
    private long startTime; // Время начала выполнения потока

    public FileSearchThread(String directory) {
        this.directory = directory;
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        synchronized (FileSearchThread.class) {
            totalThreads++;
            activeThreads++;
        }

        System.out.println("Searching for files in " + directory);
        searchFiles(directory);
        System.out.println("Search in " + directory + " completed.");

        synchronized (FileSearchThread.class) {
            activeThreads--;
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Thread ID: " + this.getId());
        System.out.println("Execution Time: " + executionTime + " ms");
        System.out.println("Total Threads: " + totalThreads);
        System.out.println("Active Threads: " + activeThreads);
        System.out.println("Total Files Found: " + totalFiles);

        double percentage = ((double) executionTime / (double) getTotalExecutionTime()) * 100;
        System.out.println("Percentage of Total Execution Time: " + percentage + "%");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void searchFiles(String directory) {
        File dir = new File(directory);

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        FileSearchThread subThread = new FileSearchThread(file.getAbsolutePath());
                        subThread.start();
                    } else {
                        synchronized (FileSearchThread.class) {
                            totalFiles++;
                        }
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static long getTotalExecutionTime() {
        long totalExecutionTime = 0;
        for (Thread t : Thread.getAllStackTraces().keySet()) {
            if (t instanceof FileSearchThread) {
                totalExecutionTime += ((FileSearchThread) t).getExecutionTime();
            }
        }
        return totalExecutionTime;
    }

    private long getExecutionTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Direction path");
        String searchDirectory = in.next();

        FileSearchThread searchThread = new FileSearchThread(searchDirectory);
        searchThread.start();
    }
}
