import java.util.Scanner;
import MSGame.MSGame;
import Util.Colours;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println(Colours.BOLD + Colours.YELLOW +"Welcome to a MineSweeper Game" + Colours.RESET);
            
        MSGame minesweeper = new MSGame();

        minesweeper.printBoard();
            
        while (!minesweeper.gameOver && minesweeper.remainingCells > 0) {

            System.out.print(Colours.PURPLE + "Enter row (0 - 9) " + Colours.RESET);
            int row = s.nextInt();
            
            System.out.print(Colours.CYAN + "Enter column (0 - 9) " + Colours.RESET);
            int col = s.nextInt();
            s.nextLine(); 
           
            if (!minesweeper.isValidCell(row, col)) {
            System.out.println(Colours.RED + "Invalid input. Please enter a number between 0 and 9." + Colours.RESET);
            continue;
            }

            if (minesweeper.isRevealed(row, col)) {
            System.out.println(Colours.BLUE + "You've already revealed this cell." + Colours.RESET);
            continue;
            }
            
            minesweeper.play(row, col);
        }
        s.close();
    }
}



/* this is the main file, this is where the new Scanner would come in, a welcome message,then
I do the game method itself calling with the params (rows, cols, mines). I need a while loop so
that the game continues while remaining Cells haven't been guessed. Need to do scanner inputs 
for the guesses, then do the play though and close the scanner at the end */