package model;

import java.rmi.AlreadyBoundException;
import java.util.ArrayList;

/**
 * Created by Tom on 7/28/2015.
 */
public class Square
{
    private int value;
    private ArrayList<Integer> possibleValues;
    private ArrayList<Square> relatedSquares;

    public Square()
    {
        possibleValues = new ArrayList<Integer>();
        relatedSquares = new ArrayList<Square>();
        value = -1; for(int i=1;i<10;i++) possibleValues.add(i);
    }

    public int getValue() { return value; }

    public ArrayList<Integer> getPossibleValues()
    {
        return possibleValues;
    }

    public void removePossibleValue(int value)
    {
       if(-1 != this.value)
           return;

        int index = possibleValues.indexOf(value);
        if(-1 != index)
            possibleValues.remove(index);

        if(possibleValues.size() == 1)
            setValue(possibleValues.get(0));
    }

    //region Subject methods

    public void setValue(int value)
    {
        this.value = value;
        notifyAllObservers();
    }

    public void attach (Square related)
    {
        if(!relatedSquares.contains(related))
            relatedSquares.add(related);
    }

    private void notifyAllObservers() {
        ArrayList<Square> tempList= new ArrayList<Square>(relatedSquares);
        relatedSquares.clear();
        for (Square rs : tempList) {
            rs.update(this.value);
        }
    }

    //endregion

    //region Observer methods

    public void update(int value)
    {
        removePossibleValue(value);
    }

    //endregion
}
