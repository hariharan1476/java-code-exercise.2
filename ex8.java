import java.util.Scanner;

class MatrixOperations {
    private static int[][] matrixA, matrixB, result;
    private static int rows, cols;

    // Constructor to initialize matrices and result matrix
    public MatrixOperations(int[][] matrixA, int[][] matrixB, int rows, int cols) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rows = rows;
        this.cols = cols;
        this.result = new int[rows][cols];
    }

    // Thread class for addition operation
    static class AdditionThread extends Thread {
        public void run() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
        }
    }

    // Thread class for subtraction operation
    static class SubtractionThread extends Thread {
        public void run() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = matrixA[i][j] - matrixB[i][j];
                }
            }
        }
    }

    // Thread class for multiplication operation
    static class MultiplicationThread extends Thread {
        private int row;

        public MultiplicationThread(int row) {
            this.row = row;
        }

        public void run() {
            for (int i = 0; i < cols; i++) {
                result[row][i] = 0;
                for (int j = 0; j < cols; j++) {
                    result[row][i] += matrixA[row][j] * matrixB[j][i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix A
        System.out.print("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A: ");
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];
        System.out.println("Enter matrix A elements:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input matrix B
        System.out.print("Enter the number of rows for matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B: ");
        int colsB = scanner.nextInt();
        int[][] matrixB = new int[rowsB][colsB];
        System.out.println("Enter matrix B elements:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Check if matrices can be added, subtracted, and multiplied
        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("Matrices cannot be added, subtracted, or multiplied due to incompatible dimensions.");
            return;
        }

        // Create threads for matrix operations
        AdditionThread additionThread = new AdditionThread();
        SubtractionThread subtractionThread = new SubtractionThread();
        MultiplicationThread[] multiplicationThreads = new MultiplicationThread[rowsA];
        for (int i = 0; i < rowsA; i++) {
            multiplicationThreads[i] = new MultiplicationThread(i);
        }

        // Start threads
        additionThread.start();
        subtractionThread.start();
        for (MultiplicationThread thread : multiplicationThreads) {
            thread.start();
        }

        // Wait for threads to complete
        try {
            additionThread.join();
            subtractionThread.join();
            for (MultiplicationThread thread : multiplicationThreads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print result matrices
        System.out.println("Matrix Addition Result:");
        printMatrix(result);
        System.out.println("Matrix Subtraction Result:");
        printMatrix(result);
        System.out.println("Matrix Multiplication Result:");
        printMatrix(result);
    }

    // Utility method to print a matrix
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] getMatrixA() {
        return matrixA;
    }

    public static void setMatrixA(int[][] matrixA) {
        MatrixOperations.matrixA = matrixA;
    }

    public static int[][] getMatrixB() {
        return matrixB;
    }

    public static void setMatrixB(int[][] matrixB) {
        MatrixOperations.matrixB = matrixB;
    }

    public static int[][] getResult() {
        return result;
    }

    public static void setResult(int[][] result) {
        MatrixOperations.result = result;
    }

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        MatrixOperations.rows = rows;
    }

    public static int getCols() {
        return cols;
    }

    public static void setCols(int cols) {
        MatrixOperations.cols = cols;
    }
}
