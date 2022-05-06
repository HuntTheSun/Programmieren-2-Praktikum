/**
 * @author : Elias Haberl
 * @created : 2022-05-05
 */

import java.util.Scanner;

/** This is a program with no real use, just to learn programming */
public class Sudoku {
  /**
   * Returns a 2 dimensional array that has been defined in the task as an example
   * @return  Returns 2 dimensional array
  */
  public static final int[][] getExample() {
    int[][] exampleXY = {
      {5, 3, 0, 0, 7, 0, 0, 0, 0},
      {6, 0, 0, 1, 9, 5, 0, 0, 0},
      {0, 9, 8, 0, 0, 0, 0, 6, 0},
      {8, 0, 0, 0, 6, 0, 0, 0, 3},
      {4, 0, 0, 8, 0, 3, 0, 0, 1},
      {7, 0, 0, 0, 2, 0, 0, 0, 6},
      {0, 6, 0, 0, 0, 0, 2, 8, 0},
      {0, 0, 0, 4, 1, 9, 0, 0, 5},
      {0, 0, 0, 0, 8, 0, 0, 7, 9},
    };
    return exampleXY;
  }

  /**
   * Just a test solution to check my implementation
   * @return A solution
  */
  public static final int[][] getSolved() {
    int[][] s = new int[9][9];
    s[0][0]=4; s[0][1]=8; s[0][2]=3; s[0][3]=1; s[0][4]=5; s[0][5]=2; s[0][6]=9; s[0][7]=6; s[0][8]=7;
    s[1][0]=6; s[1][1]=1; s[1][2]=5; s[1][3]=9; s[1][4]=7; s[1][5]=8; s[1][6]=4; s[1][7]=3; s[1][8]=2;
    s[2][0]=7; s[2][1]=2; s[2][2]=9; s[2][3]=6; s[2][4]=3; s[2][5]=4; s[2][6]=1; s[2][7]=8; s[2][8]=5;
    s[3][0]=5; s[3][1]=6; s[3][2]=4; s[3][3]=8; s[3][4]=1; s[3][5]=9; s[3][6]=2; s[3][7]=7; s[3][8]=3;
    s[4][0]=2; s[4][1]=9; s[4][2]=1; s[4][3]=7; s[4][4]=6; s[4][5]=3; s[4][6]=5; s[4][7]=4; s[4][8]=8;
    s[5][0]=8; s[5][1]=3; s[5][2]=7; s[5][3]=2; s[5][4]=4; s[5][5]=5; s[5][6]=6; s[5][7]=1; s[5][8]=9;
    s[6][0]=1; s[6][1]=5; s[6][2]=8; s[6][3]=4; s[6][4]=2; s[6][5]=7; s[6][6]=3; s[6][7]=9; s[6][8]=6;
    s[7][0]=9; s[7][1]=4; s[7][2]=2; s[7][3]=3; s[7][4]=8; s[7][5]=6; s[7][6]=7; s[7][7]=5; s[7][8]=1;
    s[8][0]=3; s[8][1]=7; s[8][2]=6; s[8][3]=5; s[8][4]=9; s[8][5]=1; s[8][6]=8; s[8][7]=2; s[8][8]=4;
    return s; 
  }

  /**
   * This method prints a given 2 dimensional int array (9x9) with delimiters after every 3
   * values, vertically and horizontally
   * @param   xySystem  A 2 dimensional array with exactly a length of 9
   */
  public static final void printSudoku(int[][] xySystem) {
    System.out.printf("\t  0 1 2\t  3 4 5\t  6 7 8\t\n");
    int row = 0;
    for (int i = 0; i < 14; i++) {
      if ((i + 1) % 4 == 1) {
        System.out.printf("\t+-------+-------+-------+");
        System.out.printf("\n");
      } else {
        if (row < 9) {
          System.out.printf("      %d |", row);
          for (int q = 0; q < 8; q = q + 3) {
            System.out.printf(
                " %d %d %d |", xySystem[row][q], xySystem[row][q + 1], xySystem[row][q + 2]);
          }
          row++;
          System.out.println("\n");
        }
      }
    }
    return;
  }

  /**
   * The main method, it only creates an example using getExample, then prints it 
   * @param args  No arguments used in main method
  */
  public static void main(String[] args) {
    int[][] ex = getExample();
    Scanner userIn = new Scanner(System.in);
    boolean wasValid = true;
    while(!isSolution(ex)){
      printSudoku(ex);

      // int[][] sol = getSolved();
      // System.out.printf("Is the provided solution correct? %b %n", isSolution(sol));

      //interactive Entry
      if(!wasValid){System.out.printf("Is not a valid entry, try again \n");}
      System.out.printf("Please enter your entry in the following format: Row Column Value, example: 0 0 5\n");
      String inputString = userIn.nextLine();
      String[] rowColumnEntryStringArray = inputString.split(" ");
      int row = Integer.parseInt(rowColumnEntryStringArray[0]);
      int column = Integer.parseInt(rowColumnEntryStringArray[1]);
      int entry = Integer.parseInt(rowColumnEntryStringArray[2]);

      if(!isValidEntry(ex, row, column, entry)){wasValid = false;}
      else {
        ex[row][column] = entry;  
        wasValid = true;
      }
      System.out.print("\033[H\033[2J");
      System.out.flush();
    }

    System.out.printf("Congrats! You done did it!\n");
    return;
  }

  /**
   * Sets entry for cell
   * @param sudoku  The sudoku sheet played
   * @param row     The row of value
   * @param column  The column of value
   * @param entry   Value of entry
   * @return        True if entry possible
   */
  public static final boolean setEntry(int[][]sudoku, int row, int column, int entry) {
    boolean isValid = true;
    //checks if entry is legal and not present
    if(!isValidEntry(sudoku, row, column, entry)){isValid = false;}
    return isValid;
  }

  /**
   * checks is the Matrix is valid for the following:
   * the 2 dimensional array sudoku cannot be null
   * No row can be null
   * There must be 9 rows and columns
   * All entries must have a value between 0-9
   * @param sudoku  a 2 dimensional array
   * @return        returns true if matrix is valid
   */
  public static final boolean checkValidSudokuMatrix(int[][] sudoku) {
    boolean isValid = true;
    if (sudoku == null) {
      throw new IllegalArgumentException("The sudoku to be checked cannot be null");
    }
    // checks number of columns
    if (sudoku.length != 9) {
      throw new IllegalArgumentException("The number of columns must be exactly 9");
    }
    // checks number of rows
    for (int i = 0; i < 9; i++) {
      if (sudoku[i].length != 9) {
        throw new IllegalArgumentException("The number of rows must be exatctly 9");
      }
    }
    // checks if values in range 0-9
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (!(sudoku[i][j] >= 0 && sudoku[i][j] <= 9)) {
          throw new IllegalArgumentException("All values in the sudoku must be from 0-9.");
        }
      }
    }
    return isValid;
  }
  /**
   * Not part of the task, but handy none the less. Checks if int value is in a Range
   * @param value The value to check
   * @param min   Start of Range
   * @param max   End of Range
   * @return      True if in Range, false if not
   */
  public static final boolean inRange(int value, int min, int max) {
    if (value >= min && value <= max) {
      return true;
    } else return false;
  }
  /**
   * Checks if the entry is valid in terms of range and proximity (if it is a legal sudoku entry)
   * @param sudoku  The sudoku where the entry "lives"
   * @param row     The row of the entry 
   * @param column  The column of the entry
   * @param entry   The value of the entry
   * @return        True if valid entry, false if not
   */
  public static final boolean isValidEntry(int[][] sudoku, int row, int column, int entry) {
    boolean entryValid = true;
    // checks if it is a valid Matrix
    if (!checkValidSudokuMatrix(sudoku)) {
      entryValid = false;
    }
    // checks entry values if in Range 0-9
    if (!inRange(entry, 0, 9)) {
      throw new IllegalArgumentException("Values of entries must be 0-9");
    }
    // checks for row range
    if (!inRange(row, 0, 8)) {
      throw new IllegalArgumentException("Values of rows must be 0-8");
    }
    // checks for column range
    if (!inRange(column, 0, 8)) {
      throw new IllegalArgumentException("Values of columns must be 0-8");
    }

    // check if entry is already in row, column or in Square
    // check if value already in row
    for (int i = 0; i < 9; i++) {
      if (i == column) {
        continue;
      } // skips cell itself
      if (sudoku[row][i] == entry) {
        entryValid = false;
      }
    }
    // check if value already in column
    for (int i = 0; i < 9; i++) {
      if (i == row) {
        continue;
      } // skips cell itself
      if (sudoku[i][column] == entry) {
        entryValid = false;
      }
    }
    // checks if value is in square
    // checks which "square row" cell is in
    int squarerow = row / 3;
    int squarecolumn = column / 3;
    // iterates through the values of a given square
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i + (3 * squarerow) == row && j + (3 * squarecolumn) == column) {
          continue;
        } // skips cell itself, with the iteration scaled to the square
        if (sudoku[i + 3 * squarerow][j + 3 * squarecolumn] == entry) {
          entryValid = false;
        } // if entry is in cell already, entry is not valid
      }
    }
    return entryValid;
  }
  /**
   * checks if complete solutions has been provided/sudoku has been solved
   * @param sudoku  The sudoku to be checked (2d int Array)
   * @return        True if the solution is valid
   */
  public static final boolean isSolution(int[][] sudoku) {
    boolean isValidSolution = true;
    checkValidSudokuMatrix(sudoku);
    // iterates over each row
    for (int i = 0; i < 9; i++) {
      // iterates over each column in row
      for (int j = 0; j < 9; j++) {
        // checks if entry is invalid or 0
        if (!isValidEntry(sudoku, i, j, sudoku[i][j]) || sudoku[i][j] == 0) {
          isValidSolution = false;
        }
      }
    }
    return isValidSolution;
  }
}
