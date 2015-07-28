package model;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Tom on 7/28/2015.
 */
public class SudokuPuzzle
{
    private Square[][] puzzle;

    public SudokuPuzzle()
    {
        puzzle = new Square[9][9];
        for(int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                puzzle[i][j] = new Square();
        }
        setUpRelationships();
    }

    public void setUpRelationships()
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9;j++)
            {
                Square current = puzzle[i][j];
                for(int k=0; k<9;k++)
                {
                    if(k != j)
                        current.attach(puzzle[i][k]);
                    if(k != i)
                        current.attach(puzzle[k][j]);
                }
                int indexi = i/3;
                int indexj = j/3;
                for(int m=3*indexi; m<(3+3*indexi); m++)
                {
                    for(int n=3*indexj; n<(3+3*indexj); n++)
                    {
                        if(m != i && n != j)
                            current.attach(puzzle[m][n]);
                    }
                }
            }
        }
    }

    public void setValue(int x, int y, int value)
    {
        validateCoords(x,y);
        if(value < 1 || value > 9)
            throw new ArrayIndexOutOfBoundsException();
        puzzle[x][y].setValue(value);
    }

    public Square[][] getPuzzle()
    {
        return puzzle;
    }

    public ArrayList<Integer> getPossibleValues(int x, int y)
    {
        validateCoords(x,y);
        return puzzle[x][y].getPossibleValues();
    }

    private void validateCoords(int x, int y)
    {
        if(x > 8 || x < 0)
            throw new ArrayIndexOutOfBoundsException();
        if(y > 9 || y < 0)
            throw new ArrayIndexOutOfBoundsException();
    }
}
