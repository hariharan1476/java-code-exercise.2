
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileOperationsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("File Operations Menu:");
            System.out.println("1. Open an existing file");
            System.out.println("2. Create a new file");
            System.out.println("3. Rename a file");
            System.out.println("4. Delete a file");
            System.out.println("5. Create a directory");
            System.out.println("6. Find the absolute path of a file");
            System.out.println("7. Get the file names in a directory");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter the path of the existing file: ");
                    String existingFilePath = scanner.nextLine();
                    openFile(existingFilePath);
                    break;
                case 2:
                    System.out.print("Enter the name of the new file: ");
                    String newFileName = scanner.nextLine();
                    createNewFile(newFileName);
                    break;
                case 3:
                    System.out.print("Enter the current file path: ");
                    String currentFilePath = scanner.nextLine();
                    System.out.print("Enter the new file path: ");
                    String newFilePath = scanner.nextLine();
                    renameFile(currentFilePath, newFilePath);
                    break;
                case 4:
                    System.out.print("Enter the file path to delete: ");
                    String fileToDelete = scanner.nextLine();
                    deleteFile(fileToDelete);
                    break;
                case 5:
                    System.out.print("Enter the directory name to create: ");
                    String directoryName = scanner.nextLine();
                    createDirectory(directoryName);
                    break;
                case 6:
                    System.out.print("Enter the file path to find its absolute path: ");
                    String filePathToFind = scanner.nextLine();
                    findAbsolutePath(filePathToFind);
                    break;
                case 7:
                    System.out.print("Enter the directory path to get file names: ");
                    String directoryPath = scanner.nextLine();
                    getFileNamesInDirectory(directoryPath);
                    break;
            }
        }
    }
    private static void openFile(String filePath) {
        // Implement code to open the existing file
    }
    private static void createNewFile(String fileName) {
        // Implement code to create a new file
    }
    private static void renameFile(String currentFilePath, String newFilePath) {
        // Implement code to rename a file
    }
    private static void deleteFile(String filePath) {
        // Implement code to delete a file
    }
    private static void createDirectory(String directoryName) {
        // Implement code to create a directory
    }
    private static void findAbsolutePath(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Absolute Path: " + file.getAbsolutePath());
        } else {
            System.out.println("File does not exist.");
        }
    }
    private static void getFileNamesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            String[] fileNames = directory.list();
            System.out.println("Files in the directory:");
            for (String fileName : fileNames) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}