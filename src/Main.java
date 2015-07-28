import model.SudokuPuzzle;
import ui.CommandLineOutput;
import ui.Output;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by Tom on 7/28/2015.
 */
public class Main
{
    public static void main(String[] args) {
        SudokuPuzzle puzzle = new SudokuPuzzle();
        Output o = new CommandLineOutput(puzzle);

        /*
        puzzle.setValue(0,0,1);
        puzzle.setValue(0,1,2);
        puzzle.setValue(0,2,3);
        puzzle.setValue(1,0,4);
        puzzle.setValue(1,1,5);
        puzzle.setValue(1,2,6);
        puzzle.setValue(2,0,7);
        puzzle.setValue(2,1,8);
        */

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
        puzzle.setValue(7, 8, 5);

        o.display();

        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.print("> ");
            String input = sc.nextLine();
            if(input.equals("q"))
                return;
            if(input.equals("d")) {
                o.display();
                continue;
            }

            String[] inList = input.split(" ");
            if(2 > inList.length) {
                System.out.println("wut");
                continue;
            }

            int x = Integer.parseInt(inList[0]);
            int y = Integer.parseInt(inList[1]);
            if(2 == inList.length) {
                System.out.println("Possible values: ");
                puzzle.getPossibleValues(x, y).forEach(System.out::println);
            }
            else if(3 == inList.length) {
                int value = Integer.parseInt(inList[2]);
                puzzle.setValue(x,y, value);
                o.display();
            }
            else {
                System.out.println("wut");
                continue;
            }

        }
    }
}
