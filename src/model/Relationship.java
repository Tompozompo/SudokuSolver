package model;

import java.util.ArrayList;

/**
 * Created by Tom on 7/29/2015.
 */
public class Relationship {
    public ArrayList<Integer> possibilityCounters = new ArrayList<Integer>();
    public ArrayList<Square> squares = new ArrayList<Square>();

    public Relationship() {
        for(int i=0; i<9; i++)
            possibilityCounters.add(9);
    }

    public void add(Square square) {
        squares.add(square);
    }

    public void update(Square square) {
        //squares.remove(square);
        for(Square s : squares)
            s.removePossibleValue(square.getValue());
    }

    public void posValUpdate(int value)
    {
        int index = value-1;
        decreasePossibilityCounter(index);
        if(1 == possibilityCounters.get(index))
        {
            for(Square s : squares)
            {
                if(s.getPossibleValues().contains(value))
                    s.setValue(value);
            }
        }

    }

    public void decreasePossibilityCounter(int index)
    {
        possibilityCounters.set(index, possibilityCounters.get(index)-1);
    }

}
