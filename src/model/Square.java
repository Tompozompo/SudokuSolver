package model;

import javax.management.relation.Relation;
import java.util.ArrayList;

/**
 * Created by Tom on 7/28/2015.
 */
public class Square
{
    private int value;
    private ArrayList<Integer> possibleValues;
    //private ArrayList<Square> relatedSquares;
    private Relationship boxRel;
    private Relationship colRel;
    private Relationship rowRel;

    public Square()
    {
        possibleValues = new ArrayList<Integer>();
        //relatedSquares = new ArrayList<Square>();
        boxRel = new Relationship();
        colRel = new Relationship();
        rowRel = new Relationship();
        value = -1;
        for(int i=1;i<10;i++) possibleValues.add(i);
    }

    public int getValue() { return value; }

    public ArrayList<Integer> getPossibleValues()
    {
        return possibleValues;
    }

    public void removePossibleValue(int value)
    {
        if(value == this.value)
            return;

        int index = possibleValues.indexOf(value);
        if(-1 != index) {
            possibleValues.remove(index);
            boxRel.posValUpdate(value);
            colRel.posValUpdate(value);
            rowRel.posValUpdate(value);
        }

        if(possibleValues.size() == 1 && possibleValues.get(0) != this.value) {
            int val = possibleValues.get(0);
            setValue(val);
        }
    }

    //region Subject methods

    public void setValue(int value)
    {
        this.value = value;
        ArrayList<Integer> temp = new ArrayList<Integer>(possibleValues);
        for(int val : temp)
            removePossibleValue(val);

        notifyAllObservers();
    }

    /*
    public void attach (Square related)
    {
        if(!relatedSquares.contains(related))
            relatedSquares.add(related);
    }
    */

    public void attachBoxRel (Relationship rel)
    {
        boxRel = rel;
    }

    public void attachColRel (Relationship rel)
    {
        colRel = rel;
    }

    public void attachRowRel (Relationship rel)
    {
        rowRel = rel;
    }

    private void notifyAllObservers() {
        /*
        ArrayList<Square> tempList= new ArrayList<Square>(relatedSquares);
        relatedSquares.clear();
        for (Square rs : tempList) {
            rs.update(this);
        }
        */
        boxRel.update(this);
        rowRel.update(this);
        colRel.update(this);
    }

    //endregion

    //region Observer methods

    /*
    public void update(Square square)
    {
        relatedSquares.remove(square);
        removePossibleValue(square.getValue());
    }
    */

    //endregion
}
