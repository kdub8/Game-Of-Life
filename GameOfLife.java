import java.util.Scanner;
import java.io.File;
import java.io.*;

public class GameOfLife {

    private int rows = 0;
    private int columns = 0;
    private int[][] boardArray;
    public int genNumber = 0;

    // method: GameOfLife
    // purpose: This is a constructor that initializes a new game board by asking
    // the user for a file name and loading
    // the game board's data directly from the file.

    public GameOfLife() throws IOException {

        // method: print
        // purpose: This method prints the text on the console.

        System.out.print("Enter file name: ");
        Scanner scnr = new Scanner(System.in);

        // method: nextLine
        // purpose: This method pushes the scanner past the current line and returns the
        // input that was skipped.

        String fileName = scnr.nextLine();
        File file = new File(fileName);

        System.out.print("Enter how many generations to compute: ");
        genNumber = scnr.nextInt();

        Scanner arrayScanner = new Scanner(file);

        // method: nextInt
        // purpose: This method scans the next token of the input as a int value.

        rows = arrayScanner.nextInt();
        columns = arrayScanner.nextInt();

        boardArray = new int[rows][columns];

        // method: println
        // purpose: This method prints the text on the console and the cursor remains at
        // the start of the next line at the console.

        System.out.println("\nGeneration 1");

        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                boardArray[i][j] = arrayScanner.nextInt();
                System.out.print(boardArray[i][j] + " ");
            }
        }
        computeNextGeneration(genNumber);
    }

    // method: getColumns
    // purpose: This returns the number of columns in the game board.

    public int getColumns() throws IOException {

        return columns;
    }

    // method: getRows
    // purpose: This returns the number of rows in the game board.

    public int getRows() throws IOException {

        return rows;
    }

    // method: getCell
    // purpose: This gets the value of the cell at a given column and row, returning
    // 0
    // when the column or the row is outside the bounds of the game board.

    public int getCell(int row, int column) {

        try {

            int cellValue = boardArray[row][column];

        } catch (Exception e) {
            return 0;
        }

        int cellValue = boardArray[row][column];
        return cellValue;

    }

    // method: setCell
    // purpose: This sets the value of the cell at a given column and row.

    public void setCell(int row, int column, int value) {
        tempArray[row][column] = value;
    }

    private static int currentGen = 2;
    private int[][] tempArray;

    // method: computeNextGeneration
    // purpose: This method creates a temporary 2D array to compute the next
    // iteration of the board which contains the next generation of organisms, as
    // stated by the Rules of the Game of Life.
    // It then updates the board to represent the next generation. The argument
    // passed in represents the number
    // of generations that the user wants to calculate. To compute each generation,
    // the method recursively
    // calls itself and decrements the integer until it terminates when there are no
    // more generations left to
    // evaluate.

    public void computeNextGeneration(int generation) {

        System.out.print("\n\nGeneration " + currentGen);

        if (currentGen == 2) {
            tempArray = new int[rows][columns];
            for (int i = 0; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    tempArray[i][j] = boardArray[i][j];

                }

            }
        }
        ++currentGen;

        int valueOfCell = 0;
        int neighborCount = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                valueOfCell = getCell(i, j);
                if (valueOfCell == 1) {

                    if (getCell(i - 1, j - 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i - 1, j) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i - 1, j + 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i, j - 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i, j + 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j - 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j + 1) == 1 && (valueOfCell == 1)) {
                        ++neighborCount;
                    }

                    if (neighborCount < 2) {
                        setCell(i, j, 0);
                    }
                    if (neighborCount > 3) {
                        setCell(i, j, 0);
                    }

                    neighborCount = 0;
                }

                if (valueOfCell == 0) {

                    if (getCell(i - 1, j - 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i - 1, j) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i - 1, j + 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i, j - 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i, j + 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j - 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }
                    if (getCell(i + 1, j + 1) == 1 && (valueOfCell == 0)) {
                        ++neighborCount;
                    }

                    if (neighborCount == 3) {
                        setCell(i, j, 1);
                    }

                    neighborCount = 0;

                }

            }

        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boardArray[i][j] = tempArray[i][j];
            }
        }

        if (generation == 2) {
            print();
        } else {
            print();
            computeNextGeneration(generation - 1);
        }

    }

    // method: print
    // purpose: This method prints out the board to the console.

    public void print() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.println();

            for (int j = 0; j < columns; j++) {

                if (j == (columns - 1)) {
                    System.out.print(tempArray[i][j]);
                } else {
                    System.out.print(tempArray[i][j] + " ");
                }
            }

        }
    }

}