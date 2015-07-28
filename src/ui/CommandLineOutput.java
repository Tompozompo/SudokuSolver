package ui;

import model.Square;
import model.SudokuPuzzle;

/**
 * Created by Tom on 7/28/2015.
 */
public class CommandLineOutput extends Output {
    public CommandLineOutput(SudokuPuzzle puzzle)
    {
        super(puzzle);
    }

    public void display()
    {
        Square[][] squares = puzzle.getPuzzle();
        for(int i=0; i<9;i++)
        {
            if(i % 3 == 0)
                System.out.println("----------------------");
            int rowSep = 1;
            for(int j=0; j<9; j++)
            {
                Square s = squares[j][i];
                if(-1 == s.getValue())
                    System.out.print(" ");
                else
                    System.out.print(s.getValue());

                if(rowSep % 3 == 0 && rowSep != 9)
                    System.out.print(" @ ");
                else
                    System.out.print("|");

                rowSep++;
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}
