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

        o.display();

        Scanner sc = new Scanner(System.in);
        while(true)
        {
            if(puzzle.isPuzzleValid_sucky()) {
                System.out.print("It's done probably!");
                return;
            }

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
