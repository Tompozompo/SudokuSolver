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

    /*
    public void setUpRelationships()
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9;j++)
            {
                Square current = puzzle[i][j];
                //set up rows and columns
                for(int k=0; k<9;k++)
                {
                    if(k != j)
                        current.attach(puzzle[i][k]);
                    if(k != i)
                        current.attach(puzzle[k][j]);
                }
                int indexi = i/3;
                int indexj = j/3;
                //set up same-square
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
    */

    public void setUpRelationships()
    {

        Relationship[][] boxes = new Relationship[3][3];
        Relationship[] cols = new Relationship[9];
        Relationship[] rows = new Relationship[9];

        for(int i=0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                boxes[i][j] = new Relationship();
        }
        for(int i=0; i < 9; i++) {
            cols[i] = new Relationship();
        }

        for(int i=0; i < 9; i++) {
            rows[i] = new Relationship();
        }

        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9;j++)
            {
                //set up rows and columns
                Square current = puzzle[i][j];
                current.attachColRel(cols[i]);
                cols[i].add(current);
                current.attachRowRel(rows[j]);
                rows[j].add(current);

                //set up same-square
                int indexi = i/3;
                int indexj = j/3;
                current.attachBoxRel(boxes[indexi][indexj]);
                boxes[indexi][indexj].add(current);
            }
        }
    }

    public int getValue(int x, int y)
    {
        validateCoords(x,y);
        return puzzle[x][y].getValue();
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

    //I'm too lazy to do this right, this is good enough for me.
    public boolean isPuzzleValid_sucky()
    {
        long expected = 405; //9*9 + 9*8 + ...
        long result = 0;
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9;j++)
            {
                result += puzzle[i][j].getValue();
            }
        }
        return result == expected;
    }
}
