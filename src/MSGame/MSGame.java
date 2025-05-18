package MSGame;

import java.util.Random;
import Util.Colours;
import Util.Animations;

//hard coding in the vals for row, cols and mines for this project


public class MSGame {
    public int rows = 10;
    public int cols = 10;
    public int mines = 10;
    public char[][] board;
    public boolean[][] guessed;
    public boolean gameOver;
    public int remainingCells;
    public boolean isRevealed(int row, int col) {
    return guessed[row][col];
}

public MSGame() {
        this.board = new char[rows][cols];
        this.guessed = new boolean[rows][cols];
        this.gameOver = false;
        this.remainingCells = rows * cols - mines;
        loadBoard();
        placeMines();
    }
    
//loads the game board with empty cells 

    private void loadBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                guessed[i][j] = false;
                
            }
        }
    }

     // Randomly place mines on the game board
    private void placeMines() {
        Random random = new Random();
        int count = 0;
        while (count < mines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (board[row][col] != '*') {
                board[row][col] = '*';
                count++;
            }
        }
    }

    /*  Check if a cell is a valid cell on the game board , makes sure its not
     * a negative, that it's within the boards height, that the column isn't
     * a negative, and that the col index is within the boards width
    */
    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /* Count the number of adjacent mines to a given cell 
     * Stats with a counter, then we do a loop that checks in a 3 X 3 grid around
     * the guessed cell, int i is checking rows (one above and one below) while
     * j is checking the column (one above and one below). We check that the cell
     * is valid and within bounds and if there's a mine in next cell over, if there
     * is we count ++, then return the result of count
     */
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j) && board[i][j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

     // Reveal a cell and update the game state, subtracting from remainingCells
    public void revealCell(int row, int col) {
        if (isValidCell(row, col) && !guessed[row][col]) {
            guessed[row][col] = true;
            remainingCells--;

            if (board[row][col] == '*') {
                gameOver = true;
                return;
            }

            int count = countAdjacentMines(row, col);
            board[row][col] = (count == 0) ? '0' : (char) (count + '0');


        }
    }

    public void play(int row, int col) {
        if (gameOver || !isValidCell(row, col) || guessed[row][col]) {
            return;
        }
       
            if (board[row][col] == '*') {
                gameOver = true;
                Animations.playGameOverAnimation();
                revealAllMines();

            } else {
                revealCell(row, col);
                if (remainingCells == 0) {
                Animations.playWinAnimation();
                revealAllMines();
            
            } else {
                printBoard();
            }
        }
    }   
    
    // Reveal all the remaining mines on the game board
    private void revealAllMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '*' && !guessed[i][j]) {
                    guessed[i][j] = true;
                }
            }
        }

             printBoard();
    }

    public void printBoard() {
        System.out.println(Colours.GREY +"Remaining cells: " + Colours.RESET + Colours.BOLD + remainingCells + Colours.RESET);
        System.out.println();

        // Print column headers in Cyan
        System.out.print("    ");
        for (int i = 0; i < cols; i++) {
            System.out.print(Colours.CYAN + i + "   " + Colours.RESET);
        }
        System.out.println();

        // Print top border
        System.out.print("  +");
        for (int i = 0; i < cols - 1; i++) {
            System.out.print( " - ^" );
        }
        System.out.println(" - +");


        for (int i = 0; i < rows; i++) {
            // Print row number and row content in Purple
            System.out.print(Colours.PURPLE + i + Colours.RESET + " |");

            for (int j = 0; j < cols; j++) {
                if (guessed[i][j]) {
                   char cell = board[i][j];
                    String display;

                    if (cell == '*') {
                        display = Colours.RED + cell + Colours.RESET;
        // Apparently these are the standard colours for numbers of bombs in minesweeper? 
                    } else if (Character.isDigit(cell) && cell != '0') {
                        switch (cell) {
                            case '1': display = Colours.BLUE + cell + Colours.RESET; break;
                            case '2': display = Colours.GREEN + cell + Colours.RESET; break;
                            case '3': display = Colours.RED + cell + Colours.RESET; break;
                            case '4': display = Colours.CYAN + cell + Colours.RESET; break;
                            case '5': display = Colours.PURPLE + cell + Colours.RESET; break;
                            case '6': display = Colours.YELLOW + cell + Colours.RESET; break;
                            case '7': display = Colours.WHITE + cell + Colours.RESET; break;
                            case '8': display = Colours.BRIGHT_RED + cell + Colours.RESET; break;
                            default: display = String.valueOf(cell); break;
                        }
                    } else {
                        display = Colours.WHITE + cell + Colours.RESET;
                    }

                    System.out.print(" " + display + " |");
 
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();

             if (i < rows - 1) {
            System.out.print("  {");
            for (int j = 0; j < cols - 1; j++) {
                System.out.print(" - +");
            }
            System.out.println(" - }");
        }
    }
        // Print bottom border
        System.out.print("  +");
        for (int i = 0; i < cols - 1; i++) {
            System.out.print(" - v");
        }
        System.out.println(" - +");
        System.out.println();
    }

}    