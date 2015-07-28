package ui;

import model.SudokuPuzzle;

/**
 * Created by Tom on 7/28/2015.
 */
public abstract class Output {
    protected SudokuPuzzle puzzle;

    public Output(SudokuPuzzle puzzle)
    {
        this.puzzle = puzzle;
    }

    public abstract void display();
}
