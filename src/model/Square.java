package model;

import java.util.ArrayList;

/**
 * Created by Tom on 7/28/2015.
 */
public class Square
{
    private int value;
    private ArrayList<Integer> possibleValues;
    private Relationship boxRel;
    private Relationship colRel;
    private Relationship rowRel;

    public Square()
    {
        possibleValues = new ArrayList<Integer>();
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

    public void setValue(int value)
    {
        this.value = value;
        ArrayList<Integer> temp = new ArrayList<Integer>(possibleValues);
        for(int val : temp)
            removePossibleValue(val);

        boxRel.update(this);
        rowRel.update(this);
        colRel.update(this);
    }

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

}
