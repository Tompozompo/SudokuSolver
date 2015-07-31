package model;

import com.sun.org.apache.xml.internal.serializer.OutputPropertyUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.CommandLineOutput;
import ui.Output;

import static org.junit.Assert.*;

/**
 * Created by Tom on 7/29/2015.
 */
public class SudokuPuzzleTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testBoxRelationship() throws Exception
    {
        SudokuPuzzle puzzle = new SudokuPuzzle();
        Output o = new CommandLineOutput(puzzle);

        puzzle.setValue(0,0,1);
        puzzle.setValue(0,1,2);
        puzzle.setValue(0,2,3);
        puzzle.setValue(1,0,4);
        puzzle.setValue(1,1,5);
        puzzle.setValue(1,2,6);
        puzzle.setValue(2,0,7);
        puzzle.setValue(2,1,8);
        Assert.assertEquals(puzzle.getValue(0,0), 1);
        Assert.assertEquals(puzzle.getValue(0,1), 2);
        Assert.assertEquals(puzzle.getValue(0,2), 3);
        Assert.assertEquals(puzzle.getValue(1,0), 4);
        Assert.assertEquals(puzzle.getValue(1,1), 5);
        Assert.assertEquals(puzzle.getValue(1,2), 6);
        Assert.assertEquals(puzzle.getValue(2,0), 7);
        Assert.assertEquals(puzzle.getValue(2,1), 8);
        Assert.assertEquals(puzzle.getValue(2,2), 9);
    }

    @Test
    public void testColRelationship() throws Exception
    {
        SudokuPuzzle puzzle = new SudokuPuzzle();

        puzzle.setValue(0, 0, 1);
        puzzle.setValue(0, 1, 2);
        puzzle.setValue(0, 2, 3);
        puzzle.setValue(0, 3, 4);
        puzzle.setValue(0, 4, 5);
        puzzle.setValue(0, 5, 6);
        puzzle.setValue(0, 6, 7);
        puzzle.setValue(0, 7, 8);
        Assert.assertEquals(puzzle.getValue(0,0), 1);
        Assert.assertEquals(puzzle.getValue(0,1), 2);
        Assert.assertEquals(puzzle.getValue(0,2), 3);
        Assert.assertEquals(puzzle.getValue(0,3), 4);
        Assert.assertEquals(puzzle.getValue(0,4), 5);
        Assert.assertEquals(puzzle.getValue(0,5), 6);
        Assert.assertEquals(puzzle.getValue(0,6), 7);
        Assert.assertEquals(puzzle.getValue(0,7), 8);
        Assert.assertEquals(puzzle.getValue(0,8), 9);
    }

    @Test
    public void testRowRelationship() throws Exception
    {
        SudokuPuzzle puzzle = new SudokuPuzzle();

        puzzle.setValue(0,0,1);
        puzzle.setValue(1,0,2);
        puzzle.setValue(2,0,3);
        puzzle.setValue(3,0,4);
        puzzle.setValue(4,0,5);
        puzzle.setValue(5,0,6);
        puzzle.setValue(6,0,7);
        puzzle.setValue(7,0,8);
        Assert.assertEquals(puzzle.getValue(0,0), 1);
        Assert.assertEquals(puzzle.getValue(1,0), 2);
        Assert.assertEquals(puzzle.getValue(2,0), 3);
        Assert.assertEquals(puzzle.getValue(3,0), 4);
        Assert.assertEquals(puzzle.getValue(4,0), 5);
        Assert.assertEquals(puzzle.getValue(5,0), 6);
        Assert.assertEquals(puzzle.getValue(6,0), 7);
        Assert.assertEquals(puzzle.getValue(7,0), 8);
        Assert.assertEquals(puzzle.getValue(8,0), 9);
    }

    @Test
    public void testEasyPuzzle() throws Exception
    {
        SudokuPuzzle puzzle = new SudokuPuzzle();

        puzzle.setValue(1,0,2);
        puzzle.setValue(3,0,1);
        puzzle.setValue(4,0,7);
        puzzle.setValue(5,0,8);
        puzzle.setValue(7,0,3);

        puzzle.setValue(1,1,4);
        puzzle.setValue(3,1,3);
        puzzle.setValue(5,1,2);
        puzzle.setValue(7,1,9);

        puzzle.setValue(0,2,1);
        puzzle.setValue(8,2,6);

        puzzle.setValue(2,3,8);
        puzzle.setValue(3,3,6);
        puzzle.setValue(5,3,3);
        puzzle.setValue(6,3,5);

        puzzle.setValue(0,4,3);
        puzzle.setValue(8,4,4);

        puzzle.setValue(2,5,6);
        puzzle.setValue(3,5,7);
        puzzle.setValue(5,5,9);
        puzzle.setValue(6,5,2);

        puzzle.setValue(0,6,9);
        puzzle.setValue(8,6,2);

        puzzle.setValue(1,7,8);
        puzzle.setValue(3,7,9);
        puzzle.setValue(5,7,1);
        puzzle.setValue(7,7,6);

        puzzle.setValue(1,8,1);
        puzzle.setValue(3,8,4);
        puzzle.setValue(4,8,3);
        puzzle.setValue(5,8,6);
        puzzle.setValue(7,8,5);

        Assert.assertTrue(puzzle.isPuzzleValid_sucky());
    }

    @Test
    public void testHardPuzzle() throws Exception
    {
        SudokuPuzzle puzzle = new SudokuPuzzle();

        puzzle.setValue(6,0,6);
        puzzle.setValue(7,0,8);

        puzzle.setValue(4,1,7);
        puzzle.setValue(5,1,3);
        puzzle.setValue(8,1,9);

        puzzle.setValue(0,2,3);
        puzzle.setValue(2,2,9);
        puzzle.setValue(7,2,4);
        puzzle.setValue(8,2,5);

        puzzle.setValue(0,3,4);
        puzzle.setValue(1,3,9);

        puzzle.setValue(0,4,8);
        puzzle.setValue(2,4,3);
        puzzle.setValue(4,4,5);
        puzzle.setValue(6,4,9);
        puzzle.setValue(8,4,2);

        puzzle.setValue(7,5,3);
        puzzle.setValue(8,5,6);

        puzzle.setValue(0,6,9);
        puzzle.setValue(1,6,6);
        puzzle.setValue(6,6,3);
        puzzle.setValue(8,6,8);

        puzzle.setValue(0,7,7);
        puzzle.setValue(3,7,6);
        puzzle.setValue(4,7,8);

        puzzle.setValue(1,8,2);
        puzzle.setValue(2,8,8);

        Assert.assertTrue(puzzle.isPuzzleValid_sucky());
    }

}