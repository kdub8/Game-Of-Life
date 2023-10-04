# Game-Of-Life

# Game Of Life

## Overview

The "Game Of Life" is a Java program that simulates the evolution of cellular automata based on a set of rules. It initializes a game board using data from a file and computes multiple generations of the board using the rules of Conway's Game of Life.

## Usage

1. Compile the Java program using a Java compiler, such as `javac`:

   ```bash
   javac GameOfLife.java
   ```

2. Run the compiled program:

   ```bash
   java GameOfLife
   ```

3. Follow the program prompts to:

   - Enter the name of a file containing the initial state of the game board.
   - Specify the number of generations to compute.

4. The program will display each generation, following the rules of Conway's Game of Life, where cells can be "alive" (1) or "dead" (0).

## Constructor

The program has a constructor that initializes a new game board. It asks the user for a file name, loads the game board's data from the file, and specifies the number of generations to compute.

## Game Board

The game board is represented by a 2D array of integers, where 0 represents a dead cell and 1 represents a live cell. The dimensions of the board are determined by the data from the input file.

## Methods

- `getColumns()`: Returns the number of columns in the game board.

- `getRows()`: Returns the number of rows in the game board.

- `getCell(int row, int column)`: Gets the value of the cell at a given row and column, returning 0 for cells outside the board's bounds.

- `setCell(int row, int column, int value)`: Sets the value of the cell at a given row and column.

- `computeNextGeneration(int generation)`: Computes the next iteration of the board based on the Rules of Conway's Game of Life. It updates the board to represent the next generation and can compute multiple generations recursively.

- `print()`: Prints the current state of the board to the console.

## Rules of Conway's Game of Life

The program follows the standard rules of Conway's Game of Life:

- Any live cell with fewer than two live neighbors dies (underpopulation).
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies (overpopulation).
- Any dead cell with exactly three live neighbors becomes a live cell (reproduction).

## Note

- Ensure that the input file contains valid data, with the specified number of rows and columns.
- The program assumes that the input file format adheres to the rules of Conway's Game of Life, where 0 represents a dead cell and 1 represents a live cell.

## Author

- **Author**: Kevin Wong
