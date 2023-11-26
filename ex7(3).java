import java.util.Scanner;

class MatrixOperations {
    static int[][] matrixA;
    static int[][] matrixB;
    static int[][] resultMatrix;
    static int rows, cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter the number of rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        cols = scanner.nextInt();

        // Input matrices A and B
        matrixA = new int[rows][cols];
        matrixB = new int[rows][cols];
        resultMatrix = new int[rows][cols];

        System.out.println("Enter Matrix A:");
        inputMatrix(matrixA, scanner);

        System.out.println("Enter Matrix B:");
        inputMatrix(matrixB, scanner);

        // Create three threads for addition, subtraction, and multiplication
        Thread addThread = new Thread(() -> performAddition(matrixA, matrixB));
        Thread subThread = new Thread(() -> performSubtraction(matrixA, matrixB));
        Thread mulThread = new Thread(() -> performMultiplication(matrixA, matrixB));

        // Start the threads
        addThread.start();
        subThread.start();
        mulThread.start();

        try {
            addThread.join();
            subThread.join();
            mulThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the results
        System.out.println("Result of Addition:");
        displayMatrix(resultMatrix);

        System.out.println("Result of Subtraction:");
        displayMatrix(resultMatrix);

        System.out.println("Result of Multiplication:");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    // Function to input a matrix
    static void inputMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to perform matrix addition
    static void performAddition(int[][] A, int[][] B) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = A[i][j] + B[i][j];
            }
        }
    }

    // Function to perform matrix subtraction
    static void performSubtraction(int[][] A, int[][] B) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = A[i][j] - B[i][j];
            }
        }
    }

    // Function to perform matrix multiplication
    static void performMultiplication(int[][] A, int[][] B) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    resultMatrix[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    // Function to display a matrix
    static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
